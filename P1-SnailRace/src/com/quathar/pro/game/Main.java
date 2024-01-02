package com.quathar.pro.game;

public class Main {

    // <<-CONSTANT->>
    private static final int PLAYERS = 4;
    private static final int DISTANCE = 100;

    // <<-METHOD->>
    public static void main(String[] args) {
        Snail[] snails = new Snail[PLAYERS];
        for (int i = 0; i < snails.length; i++)
             snails[i] = new Snail(String.format("Snail%02d", i + 1));
        Race snailRace = new Race(snails, DISTANCE);

        snailRace.play();

        System.out.printf("%s WIN", snailRace.winner());
    }

}
