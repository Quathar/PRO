package com.quathar.pro.game;

/**
 * <h1>Match</h1>
 *
 * @since 2021-11-XX
 * @version 1.0
 * @author Q
 */
public class Match {

    // <<-FIELDS->>
    private final Player[] players;
    private final int maxPoints;

    // <<-CONSTRUCTOR->>
    public Match(Player[] players, int maxPoints) {
        this.players   = players;
        this.maxPoints = maxPoints;
    }

    // <<-METHODS->>
    /**
     * Initiates and controls the game play, allowing players to take turns until a winner is determined.
     * Displays the current state of the game after each turn.
     */
    public void play() {
        while (this.winner() == null) {
            this.turn();
            this.state();
        }
    }

    /**
     * Simulates a turn in the game where players take action based on random conditions.
     * Players may score points based on a random condition.
     */
    private void turn() {
        for (Player player : this.players) {
            if (((int) (Math.random() * 3)) == 2) {
                player.score();
            }
        }
    }

    /**
     * Determines the winner of the game based on the points earned by players.
     *
     * @return The winning Player object, or {@code null} if no player has reached the required points.
     */
    public Player winner() {
        Player ganador = null;
        for (Player player : this.players)
            if (player.getPoints() >= this.maxPoints)
                ganador = player;
        return ganador;
    }

    /**
     * Displays the current state of the game, showing each player's name and their accumulated points.
     */
    private void state() {
        System.out.println("\n\n");
        for (Player player : this.players)
            System.out.printf("%s:    %s%n", player.getName(), "X".repeat(player.getPoints()));
    }

}
