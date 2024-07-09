package com.game;

import java.util.Scanner;

/**
 * Entity class of TicTacToe, which is also the core class of the game
 */
public class TicTacToe {

    private Player player1;  // Player 1
    private Player player2;  // Player 2
    private Player currentPlayer;  // Current player in the game (Player 1 or player 2)
    private Board board;  // Board in the game

    /**
     * Constructor
     */
    public TicTacToe() {
        player1 = new Player('x');
        player2 = new Player('o');
        currentPlayer = player1;
        board = new Board();
    }

    /**
     * Get player 1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Get player 2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Get current player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Get board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Game process
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            char currentMarker = currentPlayer.getMarker();
            while (true) {
                System.out.println("Current Player: " + currentMarker);
                board.print();
                System.out.print("row (0-" + (board.getCells().length - 1) + "): ");
                int row = scanner.nextInt();
                System.out.print("col (0-" + (board.getCells()[0].length - 1) + "): ");
                int col = scanner.nextInt();
                if (board.isCellOutOfRange(row, col)) {
                    System.out.println("Input cell is out of range, please try again!");
                } else if (!board.isCellEmpty(row, col)) {
                    System.out.println("Input cell is not empty, please try again!");
                } else {
                    board.place(row, col, currentMarker);
                    break;
                }
            }
            if (hasWinner()) {
                System.out.print("Winner is: ");
                if (currentPlayer == player1) {
                    System.out.println("Player 1 (with marker = " + currentMarker + ")");
                } else {
                    System.out.println("Player 2 (with marker = " + currentMarker + ")");
                }
                break;
            } else if (board.isFull()) {
                System.out.println("The board is full without winner, then the game is draw!");
                break;
            } else {
                switchCurrentPlayer();
            }
        }
    }

    /**
     * Switch current player
     */
    protected void switchCurrentPlayer() {
        // Player 1 -> Player 2
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {  // Player 2 -> Player 1
            currentPlayer = player1;
        }
    }

    /**
     * Check whether the winner of game can be determined at a row
     * Attention: For convenience of testing the application, the permission modifier of the method
     * should use protected instead of private
     */
    protected boolean hasWinnerAtRow() {
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            boolean hasWinnerFlag = true;
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j] != currentPlayer.getMarker()) {
                    hasWinnerFlag = false;
                    break;
                }
            }
            if (hasWinnerFlag) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the winner of game can be determined at a column
     * Attention: For convenience of testing the application, the permission modifier of the method
     * should use protected instead of private
     */
    protected boolean hasWinnerAtColumn() {
        char[][] cells = board.getCells();
        for (int j = 0; j < cells.length; j++) {
            boolean hasWinnerFlag = true;
            for (int i = 0; i < cells[0].length; i++) {
                if (cells[i][j] != currentPlayer.getMarker()) {
                    hasWinnerFlag = false;
                    break;
                }
            }
            if (hasWinnerFlag) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the winner of game can be determined at main diagonal
     * Attention: For convenience of testing the application, the permission modifier of the method
     * should use protected instead of private
     */
    protected boolean hasWinnerAtMainDiagonal() {
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][i] != currentPlayer.getMarker()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether the winner of game can be determined at sub diagonal
     * Attention: For convenience of testing the application, the permission modifier of the method
     * should use protected instead of private
     */
    protected boolean hasWinnerAtSubDiagonal() {
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            if (cells[i][cells.length - 1 - i] != currentPlayer.getMarker()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check whether the winner of game can be determined
     * i.e. Same pieces in a row, or a column, or at main diagonal, or at sub diagonal
     * Attention: For convenience of testing the application, the permission modifier of the method
     * should use protected instead of private
     */
    protected boolean hasWinner() {
        return hasWinnerAtRow() || hasWinnerAtColumn() || hasWinnerAtMainDiagonal() || hasWinnerAtSubDiagonal();
    }
}
