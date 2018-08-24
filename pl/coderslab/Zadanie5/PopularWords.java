package pl.coderslab.Zadanie5;


import com.google.common.collect.Iterables;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PopularWords {

    public static void main(String[] args) {

        Path path = Paths.get("popular_words.txt");
        getTitles(path);
        selectMostPopularWords(path);
    }

    static void getTitles(Path path) {

        StringBuilder sb = new StringBuilder();
        Connection connect = Jsoup.connect("https://www.onet.pl");
        Connection connect2 = Jsoup.connect("http://www.gazeta.pl");
        Connection connect3 = Jsoup.connect("https://www.rp.pl/");
        try {
            getTitlesFromWebsite(sb, connect, "span.title");
            getTitlesFromWebsite(sb, connect2, "span.title");
            getTitlesFromWebsite(sb, connect3, ".teaser__title");
            saveTitlesToFile(path, sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void selectMostPopularWords(Path path) {
        ArrayList<String> words = new ArrayList<>();

        try {
            words.addAll(Files.readAllLines(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> filteredWords = removeShortWords(words);
        Map<String, Integer> popularWords = countOccurrences(filteredWords);
        Map<String, Integer> orderedPopularWords = orderWordsByOccurrences(popularWords);
        ArrayList<String> mostPopularWords = selectTopWords(orderedPopularWords);
        saveTopWordsToFile(mostPopularWords);
    }

    private static void getTitlesFromWebsite(StringBuilder sb, Connection connect, String cssQuery) throws IOException {
        Document document = connect.get();
        Elements links = document.select(cssQuery);
        for (Element elem : links) {
            sb.append(elem.text()).append(" ");
        }
    }

    private static void saveTitlesToFile(Path path, StringBuilder sb) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        String allTitles = sb.toString();
        StringTokenizer tokenizer = new StringTokenizer(allTitles, " [.],:;-!?\"" );

        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        Files.write(path, words);
    }

    private static ArrayList<String> removeShortWords(ArrayList<String> words) {
        ListIterator<String> iterator = words.listIterator();
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.length() <= 3) {
                iterator.remove();
            }
        }
//        System.out.println(words.toString());
        return words;
    }

    private static Map<String, Integer> countOccurrences(ArrayList<String> words) {
        Map<String, Integer> popularWords = new HashMap<>();

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (popularWords.containsKey(word)) {
                popularWords.put(word, popularWords.get(word) + 1);
            } else {
                popularWords.put(word, 1);
            }
        }
        return popularWords;
    }

    private static <String, Integer extends Comparable<? super Integer>> Map<String, Integer> orderWordsByOccurrences(Map<String, Integer> wordsMap) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordsMap.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        Map<String, Integer> orderedWordsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            orderedWordsMap.put(entry.getKey(), entry.getValue());
        }
        return orderedWordsMap;
    }

    private static ArrayList<String> selectTopWords(Map<String, Integer> map) {
        ArrayList<String> topWords = new ArrayList<>();
        Iterable<Map.Entry<String, Integer>> topTenWords = Iterables.limit(map.entrySet(), 10);

        for (Map.Entry<String, Integer> entry : topTenWords) {
            topWords.add(entry.getKey());
        }
//        System.out.println(topWords.toString());
        return topWords;
    }

    private static void saveTopWordsToFile(ArrayList<String> list) {
        Path path = Paths.get("most_popular_words.txt");
        try {
            Files.write(path, list );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
