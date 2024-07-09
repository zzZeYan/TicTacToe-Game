package com.game;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Player
 */
public class PlayerTest {

    private Player player = new Player('x');

    /**
     * Test constructor and getMarker method of class Player - test case 1
     */
    @Test
    public void testInitPlayer1() {
        // Positive test case
        assertEquals('x', player.getMarker());
    }

    /**
     * Test constructor and getMarker method of class Player - test case 2
     */
    @Test
    public void testInitPlayer2() {
        // Negative test case
        assertNotEquals('o', player.getMarker());
    }
}
