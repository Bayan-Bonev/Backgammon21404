package gui;

import game_functionalities.GameState;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    static final int HEIGHT = 760;
    static final int WIDTH = 1024;

    static final ImageIcon BOARD_SPRITE = new ImageIcon("Backgammon21404/sprites/backgammon_board.png");

    private final GameState gameState;

    public GameFrame(GameState gameState) {
        this.gameState = gameState; // Store the GameState instance

        setTitle("Backgammon");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Set the layout for the frame
        setLayout(new BorderLayout());

        // Add the board and pieces to the center
        GamePanel gamePanel = new GamePanel();
        add(gamePanel, BorderLayout.CENTER);

        // Create the right panel for dice and text fields
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        rightPanel.setPreferredSize(new Dimension(200, HEIGHT));

        // Add a text field above the dice
        JTextField topTextField = new JTextField("Player 1's Turn");
        topTextField.setHorizontalAlignment(JTextField.CENTER);
        topTextField.setEditable(false);
        rightPanel.add(topTextField);

        // Add dice sprites
        JLabel diceLabel1 = new JLabel(new ImageIcon("sprites/dice/dice_face1.png"));
        JLabel diceLabel2 = new JLabel(new ImageIcon("sprites/dice/dice_face2.png"));
        JPanel dicePanel = new JPanel();
        dicePanel.setLayout(new FlowLayout());
        dicePanel.add(diceLabel1);
        dicePanel.add(diceLabel2);
        rightPanel.add(dicePanel);

        // Add a text field below the dice
        JTextField bottomTextField = new JTextField("Roll the Dice");
        bottomTextField.setHorizontalAlignment(JTextField.CENTER);
        bottomTextField.setEditable(false);
        rightPanel.add(bottomTextField);

        // Add the right panel to the frame
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
    }
}