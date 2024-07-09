package com.game;

import java.util.Scanner;

/**
 * Driver class of the TicTacToe game, which is also the entry of the game
 */
public class TicTacToeDriver {

    public static void entry() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Start a new game
            System.out.println("Welcome to join the TicTacToe game!");
            TicTacToe ticTacToe = new TicTacToe();
            ticTacToe.start();

            // User can select continue playing the game
            System.out.print("Do you want to start a new game [Y or N]? ");
            String choice = scanner.nextLine();
            if (choice.equals("N")) {
                System.out.println("Thank you for playing the TicTacToe game, bye!");
                break;
            } else {
                System.out.print("\n");
            }
        }
    }

    public static void main(String[] args) {
        entry();
    }
}
