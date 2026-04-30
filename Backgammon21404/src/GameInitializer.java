import game_functionalities.*;
import game_objects.AbstractPlayer;
import game_objects.ArtificialPlayer;
import game_objects.Board;
import game_objects.Player;
import gui.StartMenu;
import java.util.Arrays;

public class GameInitializer {

    public static void initializeGameContext() {
        // Display the StartMenu
        StartMenu startMenu = new StartMenu();
        while (startMenu.isVisible()) {
            try {
                Thread.sleep(100); // Wait for user to close the StartMenu
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retrieve user selections
        String selectedDifficulty = StartMenu.selectedDifficulty;
        String selectedColor = StartMenu.selectedColor;
        String selectedGame = StartMenu.selectedGame;

        // Set the game strategy in GameContext
        GameStrategy gameStrategy = switch (selectedGame) {
            case "Табла" -> TablaStrategy.getINSTANCE();
            case "Гюлбара" -> GiulbaraStrategy.getINSTANCE();
            case "Тапа" -> TapaStrategy.getINSTANCE();
            default -> TablaStrategy.getINSTANCE();
        };
        GameContext.currentState = gameStrategy;
        GameContext.gameInstance = (Game) gameStrategy;


        // Set the difficulty in ArtificialPlayer
        ArtificialPlayer.Difficulty difficulty = switch (selectedDifficulty) {
            case "Easy" -> ArtificialPlayer.Difficulty.EASY;
            case "Medium" -> ArtificialPlayer.Difficulty.MEDIUM;
            case "Hard" -> ArtificialPlayer.Difficulty.HARD;
            default -> ArtificialPlayer.Difficulty.EASY;
        };
        GameContext.setBot(new ArtificialPlayer(difficulty));

        // Set the player's color
        boolean isWhite = selectedColor.equalsIgnoreCase("White");
        GameContext.setPlayer(new Player(isWhite));
        GameContext.currentState.arrangeBoard();

        // Determine who plays first
        determineFirstPlayer();
    }

    private static AbstractPlayer determineFirstPlayer() {
        int playerDiceSum, botDiceSum;

        do {
            TurnEngine.rollDice();
            playerDiceSum = Arrays.stream(TurnEngine.dice).sum();

            TurnEngine.rollDice();
            botDiceSum = Arrays.stream(TurnEngine.dice).sum();
        } while (playerDiceSum == botDiceSum);

        return (playerDiceSum > botDiceSum) ? GameContext.getPlayer() : GameContext.getBot();
    }
}