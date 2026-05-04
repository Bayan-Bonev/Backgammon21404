package gui;

import config.GameInitializer;
import game_functionalities.GameState;

import javax.swing.*;

public class GUISetup {

    private GameFrame gameFrame;

    public void start() {
        // Initialize the game context and retrieve the GameState
        GameState gameState = GameInitializer.initializeGameContext();

        // Initialize the GameFrame with the GameState
        setupGameFrame(gameState);
    }

    private void setupGameFrame(GameState gameState) {
        gameFrame = new GameFrame(gameState);
        gameFrame.setTitle("Backgammon - " + gameState.getGameVariant().getClass().getSimpleName());
        gameFrame.setSize(GameFrame.WIDTH, GameFrame.HEIGHT);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameFrame.setVisible(true);
    }
}