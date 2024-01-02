package com.quathar.pro.game;

/**
 * <h1>Player Model</h1>
 *
 * @since 2021-11-XX
 * @version 1.0
 * @author Q
 */
public class Player {

    // <<-FIELDS->>
    private final String name;
    private int points;

    // <<-CONSTRUCTOR->>
    public Player(String name) {
        this.name   = name;
        this.points = 0;
    }

    // <<-METHODS->>
    public void score() {
        this.points++;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

}
