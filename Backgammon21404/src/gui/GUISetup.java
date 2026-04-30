package gui;

import game_functionalities.GameStrategy;
import game_functionalities.GiulbaraStrategy;
import game_functionalities.TablaStrategy;
import game_functionalities.TapaStrategy;
import game_objects.ArtificialPlayer;

import javax.swing.*;
import java.awt.*;

public class GUISetup {

    private GameFrame gameFrame;
    public static final ArtificialPlayer.Difficulty SELECTED_DIFFICULTY =
            switch (StartMenu.selectedDifficulty) {
                case "Easy" -> ArtificialPlayer.Difficulty.EASY;
                case "Medium" -> ArtificialPlayer.Difficulty.MEDIUM;
                case "Hard" -> ArtificialPlayer.Difficulty.HARD;
                default -> ArtificialPlayer.Difficulty.EASY; // Default to EASY if no valid selection
            };
    private boolean isWhite =
            StartMenu.selectedColor.equalsIgnoreCase("White");
    private GameStrategy selectedGame = switch (StartMenu.selectedGame) {
        case "Табла" -> TablaStrategy.getINSTANCE();
        case "Гюлбара" -> GiulbaraStrategy.getINSTANCE();
        case "Тапа" -> TapaStrategy.getINSTANCE();
        default -> TablaStrategy.getINSTANCE(); //
    };

    public void start() {
        // Display the StartMenu
        StartMenu startMenu = new StartMenu();
        startMenu.setVisible(true);

        // Wait for user input (blocking until StartMenu is closed)
        while (startMenu.isVisible()) {
            try {
                Thread.sleep(100); // Small delay to avoid busy-waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Initialize the GameFrame based on user selections
        setupGameFrame();
    }

    private void setupGameFrame() {
        gameFrame = new GameFrame();
        gameFrame.setTitle("Backgammon - " + selectedGame);
        gameFrame.setSize(new Dimension(GameFrame.WIDTH, GameFrame.HEIGHT));
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameFrame.setVisible(true);
    }

}