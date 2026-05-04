package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import config.GameConfiguration;
import config.GameLauncher;
import game_functionalities.GameStrategy;
import game_functionalities.GiulbaraStrategy;
import game_functionalities.TablaStrategy;
import game_functionalities.TapaStrategy;
import game_objects.ArtificialPlayer;

public class StartMenu extends JFrame {

    private GameConfiguration config;
    private JComboBox<String> difficultyComboBox;
    private JComboBox<String> colorComboBox;
    private JComboBox<String> gameComboBox;

    public StartMenu() {
        setTitle("Start Menu");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Difficulty selection
        add(new JLabel("Select Bot Difficulty:"));
        String[] difficulties = {"Easy", "Medium", "Hard"};
        difficultyComboBox = new JComboBox<>(difficulties);
        add(difficultyComboBox);

        // Color selection
        add(new JLabel("Select Your Piece Color:"));
        String[] colors = {"White", "Black"};
        colorComboBox = new JComboBox<>(colors);
        add(colorComboBox);

        // Game selection
        add(new JLabel("Select Game:"));
        String[] games = {"Табла", "Гюлбара", "Тапа"};
        gameComboBox = new JComboBox<>(games);
        add(gameComboBox);

        // Confirm button
        JButton confirmButton = new JButton("Start Game");
        add(new JLabel());
        add(confirmButton);

        confirmButton.addActionListener(this::onStartClicked);

        setVisible(true);
    }

    private void onStartClicked(ActionEvent e) {
        GameStrategy variant = switch ((String )gameComboBox.getSelectedItem()) {
            case "Табла" -> TablaStrategy.getINSTANCE();
            case "Гюлбара" -> GiulbaraStrategy.getINSTANCE();
            case "Тапа" -> TapaStrategy.getINSTANCE();
            default -> TablaStrategy.getINSTANCE();
        };

        ArtificialPlayer.Difficulty difficulty = switch ((String)difficultyComboBox.getSelectedItem()) {
            case "Easy" -> ArtificialPlayer.Difficulty.EASY;
            case "Medium" -> ArtificialPlayer.Difficulty.MEDIUM;
            case "Hard" -> ArtificialPlayer.Difficulty.HARD;
            default -> ArtificialPlayer.Difficulty.EASY;
        };
        boolean color = (colorComboBox.getSelectedItem().toString().equals("White"))? true : false;

        config = new GameConfiguration(variant, difficulty, color);

        dispose();                            // close menu
        GameLauncher.launch(config);          // start game
    }

    public GameConfiguration getInitialConfig() {
        return config;
    }
}