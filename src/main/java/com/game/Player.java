package com.game;

/**
 * Entity class of Player
 */
public class Player {

    private char marker;  // Player's marker('x' or 'o')

    /**
     * Constructor
     */
    public Player(char marker) {
        this.marker = marker;
    }

    /**
     * Get marker of current player
     */
    public char getMarker() {
        return marker;
    }
}
