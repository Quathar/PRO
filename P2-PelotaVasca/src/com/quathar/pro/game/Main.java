package com.quathar.pro.game;

public class Main {

    // <<-CONSTANT->>
    private static final int MAX_POINTS = 21;

    // <<-METHODS->>
    public static void main(String[] args) {
        Player[] players = {
                new Player("Player 01"),
                new Player("Player 02")
        };

        Match match = new Match(players, MAX_POINTS);

        match.play();

        System.out.printf("%n%n%s WON", match.winner().getName());
    }

}
