import gui.*;

public class Main {

    public static void main(String[] args) {

        // Initialize the GameFrame
        GameFrame gameFrame = new GameFrame();
        gameFrame.setTitle("Backgammon");
        gameFrame.setVisible(true);

        // Initialize the game context
        GameInitializer.initializeGameContext();

        // Start the game loop
        Engine.gameLoop(gameFrame);
    }
}
