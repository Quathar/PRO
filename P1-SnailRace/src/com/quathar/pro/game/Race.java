package com.quathar.pro.game;

/**
 * <h1>Race</h1>
 *
 * @since 2021-11-XX
 * @version 1.0
 * @author Q
 */
public class Race {

    // <<-CONSTANTS->>
    private static final int MAX_RANDOM_SNAIL = 51;
    private static final int MAX_DISTANCE = 7;

    // <<-FIELDS->>
    private final Snail[] snails;
    private final int maxDistance;

    // <<-CONSTRUCTOR->>
    public Race(Snail[] snails, int maxDistance) {
        this.snails = snails;
        this.maxDistance = maxDistance;
    }

    // <<-METHODS->>
    /**
     * Initiates and controls the game play, iterating through turns until a winner emerges.
     * Displays the status of snails' progress after each turn.
     */
    public void play() {
        while (this.winner() == null) {
            this.turn();
            this.status();
        }
    }

    /**
     * Executes a turn by moving a randomly selected snail a random distance forward.
     * Snails' movement is determined by random values.
     */
    private void turn() {
        // We choose random snail
        int randomSnail    = (int) (Math.random() * MAX_RANDOM_SNAIL) % this.snails.length;
        // We choose a random distance for it to move forward
        int randomDistance = (int) (Math.random() * MAX_DISTANCE);

        this.snails[randomSnail].move(randomDistance);
    }

    /**
     * Displays the current status of each snail's progress in the race.
     * Prints the snails' names and the distance covered using '=' symbols.
     */
    private void status() {
        StringBuilder stringBuilder = new StringBuilder("\n\n\n");
        for (Snail snail : this.snails) {
            stringBuilder.append(snail.getName())
                         .append(":\t")
                         .append("=".repeat(snail.getDistance()))
                         .append("\n");
        }
        System.out.println(stringBuilder);
    }

    /**
     * Determines the winner of the snail race based on the maximum distance covered.
     *
     * @return The winning Snail object, or null if no snail has reached the maximum distance.
     */
    public Snail winner() {
        Snail winner = null;
        for (Snail snail : this.snails)
            if (snail.getDistance() >= this.maxDistance)
                winner = snail;
        return winner;
    }

}
