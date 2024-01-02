package com.quathar.pro.game;

import java.awt.GridLayout;

import java.io.Serial;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * <h1>Tic Tac Toe</h1>
 * <br>
 * <p>
 *     Tic-tac-toe game with graphical environment from the javax.swing.* package
 * </p>
 *
 * @since 2022-04-01
 * @version 1.0
 * @author Q
 */
public class TicTacToe extends JFrame {

    // <<-CONSTANTS->>
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int    LINE            = 3;
    private static final String FRAME_TITLE     = "Tic Tac Toe";
    private static final String WINNING_MESSAGE = "YOU HAVE WON... GAME OVER";
    private static final String LOSING_MESSAGE  = "YOU HAVE LOST... GAME OVER";
    private static final String TIE_MESSAGE     = "TIE... GAME OVER";

    // <<-FIELDS->>
    private JPanel contentPane;
    private JButton[][] buttons;
    private final String human;
    private final String robot;

    // <<-CONSTRUCTOR->>
    public TicTacToe(String human, String robot) {
        super(FRAME_TITLE);
        this.human = human;
        this.robot = robot;
        this.drawBoard();
        if (Math.random() < 0.5)
            this.turnCPU();
    }

    // <<-METHODS->>

    // ========================
    // = = = Design Zone = = =
    // = = = Design Zone = = =
    // = = = Design Zone = = =
    // ========================
    private void drawBoard() {
        super.setDefaultCloseOperation(HIDE_ON_CLOSE);
        super.setBounds((int) (1920 * 0.40),
                        (int) (1080 * 0.40),
                        300,
                        300);
        super.setResizable(false);

        this.contentPane = new JPanel();
        this.contentPane.setLayout(new GridLayout(LINE, LINE));
        super.setContentPane(this.contentPane);

        this.buttons = new JButton[LINE][LINE];
        for (int i = 0; i < LINE; i++)
            for (int j = 0; j < LINE; j++) {
                this.buttons[i][j] = new JButton();
                int finalI = i;
                int finalJ = j;
                this.buttons[i][j].addActionListener(e -> {
                    this.occupyButton(finalI, finalJ, this.human);
                    this.turnCPU();
                    if (this.hasCompleted())
                        this.end();
                });
                this.contentPane.add(this.buttons[i][j]);
            }
    }

    // ========================
    // = = = Logic Zone = = =
    // = = = Logic Zone = = =
    // = = = Logic Zone = = =
    // ========================
    /**
     * Sets the text of a button at the specified coordinates (x, y) to the given chip
     * and disables the button.
     *
     * @param x    The x-coordinate of the button.
     * @param y    The y-coordinate of the button.
     * @param chip The chip to set on the button.
     */
    private void occupyButton(int x, int y, String chip) {
        this.buttons[x][y].setText(chip);
        this.buttons[x][y].setEnabled(false);
    }

    /**
     * Executes the CPU's turn if the game board is not full.
     */
    private void turnCPU() {
        if (!this.isFull())
            while (!this.pressCPU()) ;
    }

    /**
     * Checks if the game board is full.
     *
     * @return {@code true} if the board is full, {@code false} otherwise.
     */
    private boolean isFull() {
        for (int i = 0; i < LINE; i++)
            for (int j = 0; j < LINE; j++)
                if (this.buttons[i][j].getText().isEmpty())
                    return false;
        return true;
    }

    /**
     * Performs a random selection of an empty button by the CPU.
     *
     * @return {@code true} if the CPU successfully selects an empty button, {@code false} otherwise.
     */
    private boolean pressCPU() {
        int x = (int) (Math.random() * LINE);
        int y = (int) (Math.random() * LINE);

        if (this.buttons[x][y].getText().isEmpty()) {
            this.occupyButton(x, y, this.robot);
            return true;
        }
        return false;
    }

    /**
     * Checks if the game has been completed (board full or someone has won).
     *
     * @return {@code true} if the game has been completed, {@code false} otherwise.
     */
    private boolean hasCompleted() {
        return this.isFull() || this.hasWon(this.human) || this.hasWon(this.robot);
    }

    /**
     * Ends the game by displaying a message dialog indicating the result.
     */
    private void end() {
        if (this.hasWon(this.human))
             JOptionPane.showMessageDialog(this.contentPane, WINNING_MESSAGE);
        else if (this.hasWon(this.robot))
             JOptionPane.showMessageDialog(this.contentPane, LOSING_MESSAGE);
        else JOptionPane.showMessageDialog(this.contentPane, TIE_MESSAGE);
        super.dispose();
    }

    /**
     * Checks if the specified chip has won the game based on the current board state.
     *
     * @param chip The chip to check for winning condition.
     * @return {@code true} if the specified chip has won, {@code false} otherwise.
     */
    private boolean hasWon(String chip) {
        int counter;

        // Check columns
        for (int column = 0; column < LINE; column++) {
            counter = 0;
            for (int row = 0; row < LINE; row++)
                if (this.buttons[column][row].getText().equals(chip))
                    counter++;
            if (counter == LINE)
                return true;
        }

        // Check rows
        for (int row = 0; row < LINE; row++) {
            counter = 0;
            for (int column = 0; column < LINE; column++)
                if (this.buttons[column][row].getText().equals(chip))
                    counter++;
            if (counter == LINE)
                return true;
        }

        // Check 1st diagonal
        counter = 0;
        for (int i = 0; i < LINE; i++)
            if (this.buttons[i][i].getText().equals(chip))
                counter++;
        if (counter == LINE)
            return true;

        // Check 2nd diagonal
        counter = 0;
        int j = LINE - 1;
        for (int i = 0; i < LINE; i++) {
            if (this.buttons[i][j].getText().equals(chip))
                counter++;
            j--;
        }

        return counter == LINE;
    }

}
