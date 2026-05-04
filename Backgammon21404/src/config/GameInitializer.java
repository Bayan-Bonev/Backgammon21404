package config;

import game_functionalities.GameState;
import gui.StartMenu;

public class GameInitializer {

    public static GameState initializeGameContext() {
        // Display the StartMenu
        StartMenu startMenu = new StartMenu();
        while (startMenu.isVisible()) {
            try {
                Thread.sleep(100); // Wait for user to close the StartMenu
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retrieve user selections from StartMenu
        GameConfiguration config = startMenu.getInitialConfig();

        // Initialize and return the game state
        return new GameState(config);
    }
}