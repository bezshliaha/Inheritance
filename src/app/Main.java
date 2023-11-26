package app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bet;

        do {
            System.out.print("Enter your bet (in EUR): ");
            bet = Double.parseDouble(scanner.nextLine().replace(",", "."));

            if (bet <= 0) {
                System.out.println("Invalid bet. Please enter a positive amount.");
            }
        } while (bet <= 0);

        while (true) {
            int rolledNumber = DiceRoller.rollDice();

            System.out.println("Dice rolled: " + rolledNumber);

            Craps game;

            if (rolledNumber < 3) {
                game = new WinLessThan3(bet);
            } else if (rolledNumber >= 3 && rolledNumber <= 7) {
                game = new Win3to7(bet);
            } else {
                game = new WinMoreThan7(bet);
            }

            double winAmount = game.calculateWin();
            System.out.printf("Your win: %.2f EUR%n", winAmount);

            System.out.print("Do you want to roll the dice again? (yes/no): ");
            String answer = scanner.nextLine().toLowerCase();

            if (answer.equals("yes")) {
                do {
                    System.out.print("Enter your new bet (in EUR): ");
                    bet = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    if (bet <= 0) {
                        System.out.println("Invalid bet. Please enter a positive amount.");
                    }
                } while (bet <= 0);
            } else {
                break;
            }
        }

        scanner.close();
    }
}