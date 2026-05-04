package config;

import game_functionalities.GameStrategy;
import game_objects.ArtificialPlayer;

public class GameConfiguration {

    public static GameConfiguration initialConfiguration;

    private final GameStrategy variant;
    private final ArtificialPlayer.Difficulty difficulty;
    private final int playerIsWhite;

    public GameConfiguration(GameStrategy variant, ArtificialPlayer.Difficulty difficulty, boolean playerIsWhite) {
        this.variant = variant;
        this.difficulty = difficulty;
        this.playerIsWhite = playerIsWhite ? 1 : 0;
    }

    public GameStrategy getVariant() {
        return variant;
    }

    public ArtificialPlayer.Difficulty getDifficulty() {
        return difficulty;
    }

    public int getPlayerIsWhite() {
        return playerIsWhite;
    }
}