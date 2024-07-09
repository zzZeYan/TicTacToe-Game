package com.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TicTacToe
 */
public class TicTacToeTest {

    private TicTacToe ticTacToe = new TicTacToe();

    /**
     * Test constructor of class TicTacToe - test case 1
     */
    @Test
    public void testInitTicTacToe1() {
        // Positive test case
        Player player1 = new Player('x');
        Player player2 = new Player('o');
        Board board = new Board();

        assertEquals(ticTacToe.getPlayer1().getMarker(), player1.getMarker());
        assertEquals(ticTacToe.getPlayer2().getMarker(), player2.getMarker());
        assertEquals(ticTacToe.getCurrentPlayer().getMarker(), player1.getMarker());
        assertArrayEquals(ticTacToe.getBoard().getCells(), board.getCells());
    }

    /**
     * Test constructor of class TicTacToe - test case 2
     */
    @Test
    public void testInitTicTacToe2() {
        // Negative test case
        Player player1 = new Player('x');
        Player player2 = new Player('o');
        Board board = new Board();
        board.place(0, 1, 'x');

        assertNotEquals(ticTacToe.getPlayer1().getMarker(), player2.getMarker());
        assertNotEquals(ticTacToe.getPlayer2().getMarker(), player1.getMarker());
        assertNotEquals(ticTacToe.getCurrentPlayer().getMarker(), player2.getMarker());
        assertNotEquals(ticTacToe.getBoard().getCells()[0][1], board.getCells()[0][1]);
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 1
     */
    @Test
    public void testSwitchCurrentPlayer1() {
        // Positive test cases
        assertEquals('x', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertEquals('o', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertEquals('x', ticTacToe.getCurrentPlayer().getMarker());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 2
     */
    @Test
    public void testSwitchCurrentPlayer2() {
        // Negative test cases
        assertNotEquals('o', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertNotEquals('x', ticTacToe.getCurrentPlayer().getMarker());

        ticTacToe.switchCurrentPlayer();
        assertNotEquals('o', ticTacToe.getCurrentPlayer().getMarker());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 1
     */
    @Test
    public void testHasWinner1() {
        // Positive test case: three pieces('x') at the same row
        ticTacToe.getBoard().place(1, 1, 'x');
        ticTacToe.getBoard().place(0, 1, 'o');
        ticTacToe.getBoard().place(1, 2, 'x');
        ticTacToe.getBoard().place(0, 2, 'o');
        ticTacToe.getBoard().place(1, 0, 'x');

        assertTrue(ticTacToe.hasWinnerAtRow());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 2
     */
    @Test
    public void testHasWinner2() {
        // Positive test case: three pieces('o') at the same column
        ticTacToe.switchCurrentPlayer();

        ticTacToe.getBoard().place(1, 1, 'x');
        ticTacToe.getBoard().place(0, 2, 'o');
        ticTacToe.getBoard().place(1, 0, 'x');
        ticTacToe.getBoard().place(1, 2, 'o');
        ticTacToe.getBoard().place(0, 0, 'x');
        ticTacToe.getBoard().place(2, 2, 'o');

        assertTrue(ticTacToe.hasWinnerAtColumn());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 3
     */
    @Test
    public void testHasWinner3() {
        // Positive test case: three pieces('x') at the main diagonal
        ticTacToe.getBoard().place(0, 0, 'x');
        ticTacToe.getBoard().place(1, 0, 'o');
        ticTacToe.getBoard().place(1, 1, 'x');
        ticTacToe.getBoard().place(2, 0, 'o');
        ticTacToe.getBoard().place(2, 2, 'x');

        assertTrue(ticTacToe.hasWinnerAtMainDiagonal());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 4
     */
    @Test
    public void testHasWinner4() {
        // Positive test case: three pieces('o') at the sub diagonal
        ticTacToe.switchCurrentPlayer();

        ticTacToe.getBoard().place(0, 1, 'x');
        ticTacToe.getBoard().place(0, 2, 'o');
        ticTacToe.getBoard().place(0, 0, 'x');
        ticTacToe.getBoard().place(1, 1, 'o');
        ticTacToe.getBoard().place(2, 2, 'x');
        ticTacToe.getBoard().place(2, 0, 'o');

        assertTrue(ticTacToe.hasWinnerAtSubDiagonal());
    }

    /**
     * Test switchCurrentPlayer method of class TicTacToe - test case 4
     */
    @Test
    public void testHasWinner5() {
        // Negative test case: a draw game
        ticTacToe.getBoard().place(1, 1, 'x');
        ticTacToe.getBoard().place(0, 1, 'o');
        ticTacToe.getBoard().place(0, 2, 'x');
        ticTacToe.getBoard().place(2, 0, 'o');
        ticTacToe.getBoard().place(2, 2, 'x');
        ticTacToe.getBoard().place(1, 2, 'o');
        ticTacToe.getBoard().place(1, 0, 'x');
        ticTacToe.getBoard().place(0, 0, 'o');
        ticTacToe.getBoard().place(2, 1, 'x');

        assertFalse(ticTacToe.hasWinner());
    }
}
