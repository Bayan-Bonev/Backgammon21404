package game_functionalities;

import config.GameConfiguration;
import game_objects.*;

public class GameState {

    private Board board;
    private Player player;
    private ArtificialPlayer bot;
    private AbstractPlayer currentPlayer;
    private GameStrategy gameVariant;

    public GameState(GameConfiguration config) {
        this.setBoard(new Board());
        this.setPlayer(new Player());
        this.setBot(new ArtificialPlayer(config.getDifficulty()));
        this.setCurrentPlayer(config.getPlayerIsWhite() == 1 ? this.getPlayer() : this.getBot());
    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArtificialPlayer getBot() {
        return bot;
    }

    public void setBot(ArtificialPlayer bot) {
        this.bot = bot;
    }

    public AbstractPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(AbstractPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStrategy getGameVariant() {
        return gameVariant;
    }

    public void setGameVariant(GameStrategy gameVariant) {
        this.gameVariant = gameVariant;
    }
}
