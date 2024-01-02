package com.quathar.pro.game;

/**
 * <h1>Snail Model</h1>
 *
 * @since 2021-11-XX
 * @version 1.0
 * @author Q
 */
public class Snail {

    // <<-CONSTANT->>
    private static final int INITIAL_DISTANCE = 0;

    // <<-FIELDS->>
    private String name;
    private int distance;

    // <<-CONSTRUCTOR->>
    public Snail(String name) {
        this.name = name;
        this.distance = INITIAL_DISTANCE;
    }

    // <<-METHODS->>
    public void move(int distance) {
        this.distance += distance;
    }

    @Override
    public String toString() {
        return String.format("Snail [name=%s, distance=%s]", this.name, this.distance);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

}
