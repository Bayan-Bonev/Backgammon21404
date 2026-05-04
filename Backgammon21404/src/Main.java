import config.GameInitializer;
import game_functionalities.GameState;
import gui.GameFrame;

public class Main {

    public static void main(String[] args) {
        // Initialize the game context and retrieve the GameState
        GameState gameState = GameInitializer.initializeGameContext();

        // Initialize the GameFrame with the GameState
        GameFrame gameFrame = new GameFrame(gameState);
        gameFrame.setTitle("Backgammon");
        gameFrame.setVisible(true);

        // Start the game loop
        Engine.gameLoop(gameFrame);
    }
}