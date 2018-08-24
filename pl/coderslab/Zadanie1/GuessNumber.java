package pl.coderslab.Zadanie1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String[] args) {
        guessNumber(generateNumber());
    }

    static int generateNumber() {
        Random generator = new Random();
        return generator.nextInt(100)+1;
    }

    static void guessNumber(int randomNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zgadnij liczbę: ");
        int a = 0;

        while (a != randomNumber) {
            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba.");
                System.out.print("Zgadnij liczbę: ");
                scanner.next();
            }
            a = scanner.nextInt();

            if (a < randomNumber) {
                System.out.print("Za mało!\nZgadnij liczbę: ");
            } else if (a > randomNumber) {
                System.out.print("Za dużo!\nZgadnij liczbę: ");
            }
        }
        System.out.println("Zgadłeś! Chcesz zagrać jeszcze raz?");

        if (scanner.next().toLowerCase().equals("tak")) {
            guessNumber(generateNumber());
        } else {
            scanner.close();
        }
    }
}
