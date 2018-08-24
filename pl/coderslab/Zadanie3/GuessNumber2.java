package pl.coderslab.Zadanie3;

import java.util.Scanner;

public class GuessNumber2 {

    public static void main(String[] args) {

        guessNumber();
    }

    static void guessNumber() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Pomyśl liczbę od 1 do 1000, a ja zgadnę w max. 10 próbach.");
        int min = 1;
        int max = 1000;
        int guess;
        guess = ((max - min) / 2) + min;
        String reply = "";
        int counter = 1;

        while (!reply.equals("trafiłeś")) {
            System.out.println("Zgaduję: " + guess);
            System.out.println("Wpisz: więcej / mniej / trafiłeś");
            reply = scan.nextLine();

            if (reply.equals("trafiłeś")) {
                System.out.println("Wygrałem!");
            } else {
                if (reply.equals("mniej")) {
                    max = guess;
                    counter++;
                } else if (reply.equals("więcej")) {
                    min = guess;
                    counter++;
                } else {
                    System.out.println("Nie rozumiem!");
                }
                if (min == 999) {
                    guess = 1000;
                } else {
                    guess = ((max - min) / 2) + min;
                }
            }
            if (!reply.equals("trafiłeś") && counter > 10 && guess != 1000) {
                System.out.println("Nie oszukuj!");
            }
        }
    }
}
