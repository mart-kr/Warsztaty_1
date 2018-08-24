package pl.coderslab.Zadanie2;

import java.util.*;

public class LottoSimulator {

    public static void main(String[] args) {
        giveResults(getLotteryNumbers(), getUserNumbers() );
    }

    static Integer[] getUserNumbers() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> userNumbers= new ArrayList<>();
        System.out.println("Podaj liczbę z zakresu 1-49:");

        while (userNumbers.size() < 6) {
            while (!scan.hasNextInt()) {
                scan.next();
                System.out.println("To nie liczba!");
            }
            Integer number = scan.nextInt();

            if (number < 1 || number > 49) {
                System.out.println("To nie jest liczba z zakresu 1-49!");
            } else if (userNumbers.contains(number)) {
                System.out.println("Tę liczbę już podałeś. Podaj inną liczbę!");
            } else {
                userNumbers.add(number);
                if (userNumbers.size() < 6) {
                    System.out.println("Podaj kolejną liczbę:");
                }
            }
            scan.nextLine();
        }
        scan.close();

        return userNumbers.toArray(new Integer[0]);
    }

    static Integer[] getLotteryNumbers() {
        Integer[] shuffleArray = new Integer[49];

        for (int i = 0; i < shuffleArray.length; i++) {
            shuffleArray[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(shuffleArray));
        Integer[] lotteryNumbers;
        lotteryNumbers = Arrays.copyOf(shuffleArray, 6);

        return lotteryNumbers;
    }

    static void giveResults(Integer[] lotteryResults, Integer[] userResults) {
        Arrays.sort(userResults);
        System.out.println("Twoje liczby: " + Arrays.toString(userResults));
        System.out.println("Wylosowane liczby: " + Arrays.toString(lotteryResults));
        int counter = 0;

        for (int i = 0; i < userResults.length; i++) {
            if (Arrays.asList(lotteryResults).contains(userResults[i])) {
                counter++;
            }
        }
        if (counter == 3) {
            System.out.println("Trafiłeś trójkę!");
        } else if (counter == 4) {
            System.out.println("Trafiłeś czwórkę!");
        } else if (counter == 5) {
            System.out.println("Trafiłeś piątkę!");
        } else if (counter == 6) {
            System.out.println("Brawo! Jesteś teraz milionerem!");
        } else {
            System.out.println("Nie tym razem.");
        }
    }
}
