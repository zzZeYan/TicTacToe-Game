package com.game;

/**
 * Entity class of Board
 */
public class Board {

    private static final int SIZE = 3;  // Size of board, which is a constant
    private char[][] cells;  // Cells of board(SIZE * SIZE)

    /**
     * Constructor
     */
    public Board() {
        // Init a SIZE * SIZE board(here SIZE = 3), and clear it
        cells = new char[SIZE][SIZE];
        clear();
    }

    /**
     * Get cells of board
     */
    public char[][] getCells() {
        return cells;
    }

    /**
     * Check whether player's input position (x, y) of cell is out of range
     */
    public boolean isCellOutOfRange(int x, int y) {
        return x < 0 || x >= cells.length || y < 0 || y >= cells[0].length;
    }

    /**
     * Check whether player's input position (x, y) of cell is empty
     */
    public boolean isCellEmpty(int x, int y) {
        if (isCellOutOfRange(x, y)) {
            return false;
        }
        return cells[x][y] == ' ';
    }

    /**
     * Place an piece at position (x, y) of cell for current player
     */
    public void place(int x, int y, char marker) {
        // First, the status of cell at position (x, y) should be checked
        // If it is not empty, then the piece should not be placed
        if (!isCellEmpty(x, y)) {
            return;
        }
        // Place the piece
        cells[x][y] = marker;
    }

    /**
     * Check whether the board is full, i.e. every cell is not ' '
     */
    public boolean isFull() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (isCellEmpty(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Clear the board, i.e. init every cell of the board by empty character ' '
     */
    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /**
     * Print the board with specific format
     */
    public void print() {
        for (int i = 0; i < cells.length; i++) {
            // Print top border
            if (i == 0) {
                System.out.print("-");
                for (int j = 0; j < cells[0].length; j++) {
                    System.out.print("--");
                }
                System.out.print("\n");
            }
            // Print every cell in the board
            System.out.print("|");
            for (int j = 0; j < cells[0].length; j++) {
                System.out.print(cells[i][j] + "|");
            }
            System.out.print("\n");
        }
        // Print bottom border
        System.out.print("-");
        for (int i = 0; i < cells.length; i++) {
            System.out.print("--");
        }
        System.out.print("\n");
    }
}
