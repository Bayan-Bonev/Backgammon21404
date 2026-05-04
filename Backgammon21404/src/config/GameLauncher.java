package config;

import game_functionalities.GameState;
import gui.GameFrame;

public class GameLauncher {
    public static void launch(GameConfiguration config) {
        // Initialize the game state
        GameState gameState = new GameState(config);

        // Arrange the board
        gameState.getGameVariant().arrangeBoard();

        // Open the game window
        new GameFrame(gameState).setVisible(true);
    }
}