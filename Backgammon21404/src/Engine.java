import game_functionalities.GameContext;
import game_functionalities.TurnEngine;
import game_objects.Player;
import gui.GameFrame;

public class Engine {

    static final int FPS = 60;

    public static void gameLoop(GameFrame gameFrame) {
        long lastTime = System.nanoTime();
        double nsPerFrame = 1_000_000_000.0 / FPS;

        while (true) {
            long now = System.nanoTime();
            double delta = (now - lastTime) / nsPerFrame;

            if (delta >= 1) {
                // Update game state
                TurnEngine turnEngine = TurnEngine.getINSTANCE();
                if (!turnEngine.isOver()) {
                    turnEngine.turn();
                } else {
                    break;
                }

                // Render the game
                gameFrame.getContentPane().repaint();

                lastTime = now;
            }
        }
    }
}
