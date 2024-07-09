package com.game;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Board
 */
public class BoardTest {

    private Board board = new Board();

    /**
     * Test constructor of class Board - test case 1
     */
    @Test
    public void testInitBoard1() {
        // Positive test case
        char[][] expectedBoard = new char[3][3];
        for (int i = 0; i < expectedBoard.length; i++) {
            for (int j = 0; j < expectedBoard[0].length; j++) {
                expectedBoard[i][j] = ' ';
            }
        }
        assertArrayEquals(expectedBoard, board.getCells());
    }

    /**
     * Test constructor of class Board - test case 2
     */
    @Test
    public void testInitBoard2() {
        // Negative test case
        char[][] notExpectedBoard = new char[3][3];
        for (int i = 0; i < notExpectedBoard.length; i++) {
            for (int j = 0; j < notExpectedBoard[0].length; j++) {
                notExpectedBoard[i][j] = 'x';
            }
        }
        assertNotEquals(notExpectedBoard, board.getCells());
    }

    /**
     * Test isCellOutOfRange method of class Board - test case 1
     */
    @Test
    public void testIsCellOutOfRange1() {
        // Positive test cases
        assertTrue(board.isCellOutOfRange(0, 3));
        assertTrue(board.isCellOutOfRange(-1, 2));
    }

    /**
     * Test isCellOutOfRange method of class Board - test case 2
     */
    @Test
    public void testIsCellOutOfRange2() {
        // Negative test cases
        assertFalse(board.isCellOutOfRange(0, 2));
        assertFalse(board.isCellOutOfRange(1, 1));
    }

    /**
     * Test isCellEmpty method of class Board - test case 1
     */
    @Test
    public void testIsCellEmpty1() {
        // Positive test cases
        board.place(0, 1, 'x');
        board.place(1, 2, 'o');

        assertTrue(board.isCellEmpty(0, 2));
        assertTrue(board.isCellEmpty(1, 1));
        assertTrue(board.isCellEmpty(2, 0));
    }

    /**
     * Test isCellEmpty method of class Board - test case 2
     */
    @Test
    public void testIsCellEmpty2() {
        // Negative test cases
        board.place(0, 1, 'x');
        board.place(1, 2, 'o');

        assertFalse(board.isCellEmpty(0, 1));
        assertFalse(board.isCellEmpty(1, 2));
        assertFalse(board.isCellEmpty(0, 1));
        assertFalse(board.isCellEmpty(1, 2));
    }

    /**
     * Test place method of class Board - test case 1
     */
    @Test
    public void testPlace1() {
        // Positive test cases
        board.place(0, 1, 'x');
        board.place(1, 2, 'o');

        char[][] cells = board.getCells();

        assertEquals('x', cells[0][1]);
        assertEquals('o', cells[1][2]);
    }

    /**
     * Test place method of class Board - test case 2
     */
    @Test
    public void testPlace2() {
        // Negative test cases
        board.place(0, 1, 'x');
        board.place(1, 2, 'o');

        char[][] cells = board.getCells();

        assertNotEquals('o', cells[0][1]);
        assertNotEquals('x', cells[1][2]);
        assertNotEquals('x', cells[2][0]);
        assertNotEquals('x', cells[2][1]);
    }

    /**
     * Test isFull method of class Board - test case 1
     */
    @Test
    public void testIsFull1() {
        // Positive test case
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                board.place(i, j, 'x');
            }
        }
        assertTrue(board.isFull());
    }

    /**
     * Test isFull method of class Board - test case 2
     */
    @Test
    public void testIsFull2() {
        // Negative test case
        assertFalse(board.isFull());
    }

    /**
     * Test clear method of class Board - test case 1
     */
    @Test
    public void testClear1() {
        // Positive test case
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                board.place(i, j, 'x');
            }
        }
        board.clear();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    /**
     * Test clear method of class Board - test case 2
     */
    @Test
    public void testClear2() {
        // Negative test case
        char[][] cells = board.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                board.place(i, j, 'x');
            }
        }
        board.clear();

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                assertFalse(!board.isCellEmpty(i, j));
            }
        }
    }

    /**
     * Test print method of class Board - test case 1
     */
    @Test
    public void testPrint1() {
        // Positive test case
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        board.print();

        assertEquals("-------\n| | | |\n| | | |\n| | | |\n-------\n", output.toString());
        System.setOut(System.out);
    }

    /**
     * Test print method of class Board - test case 2
     */
    @Test
    public void testPrint2() {
        // Negative test case
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        board.place(0, 1, 'x');
        board.place(1, 2, 'o');
        board.place(0, 0, 'x');
        board.print();

        assertNotEquals("-------\n| |x| |\n| | |o|\n| | | |\n-------\n", output.toString());
        System.setOut(System.out);
    }
}
