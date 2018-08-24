package pl.coderslab.Zadanie4;


import java.util.Random;
import java.util.StringTokenizer;

public class Dices {

    public static void main(String[] args) {

        try {
            playDices("5D6+30");
        } catch (NumberFormatException e) {
            System.out.println("Błędny format danych!");
        }
    }

    static void playDices(String str) throws NumberFormatException {
        int x = 0, y = 0, z = 0, result = 0;
        String sign = "";
        Random random = new Random();
        StringTokenizer tokenizer1 = new StringTokenizer(str,"D");

        if (tokenizer1.countTokens() == 2) {
            x = Integer.parseInt(tokenizer1.nextToken());
        } else if (tokenizer1.countTokens() == 1) {
            x = 1;
        } else {
            System.out.println("Błędny format danych!");
        }
        String strWithoutD = tokenizer1.nextToken();
        StringTokenizer tokenizer2 = new StringTokenizer(strWithoutD, "+-", true);

        if (tokenizer2.countTokens() == 3) {
            y = Integer.parseInt(tokenizer2.nextToken());
            sign = tokenizer2.nextToken();
            z = Integer.parseInt(tokenizer2.nextToken());
        } else if (tokenizer2.countTokens() == 1) {
            y = Integer.parseInt(tokenizer2.nextToken());
        } else {
            System.out.println("Błędny format danych!");
        }
        if (y != 0) {
            for (int i = 0; i < x; i++ ) {
                result +=  random.nextInt(y) +1;
            }
        }
        if (sign.equals("+")) {
            result += z;
        } else if (sign.equals("-")) {
            result -=z;
        }
        System.out.println(result);
    }

}
