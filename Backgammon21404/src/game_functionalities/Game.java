package game_functionalities;

import game_objects.*;
import utilities.board_logic_utilities.*;

public abstract class Game {

    private final MoveValidator validator = (MoveValidator) MoveAgentFactory.createInstance("validator");

    private Board board;
    private AbstractPlayer currentPlayer;
    private Player player;
    private ArtificialPlayer bot;

    Game() {
        this.setBoard((Board) GameObjectFactory.createInstance("Board"));
    }

    Game(AbstractPlayer currentPlayer) {
        this.setCurrentPlayer(currentPlayer);
        this.player = (currentPlayer instanceof Player)?
                (Player)currentPlayer:
                (Player)GameObjectFactory.createInstance("Player");
        this.bot = (currentPlayer instanceof ArtificialPlayer)?
                (ArtificialPlayer) currentPlayer :
                (ArtificialPlayer) GameObjectFactory.createInstance("artificial player");
        this.setBoard((Board) GameObjectFactory.createInstance("Board"));
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer instanceof Player)? this.bot:this.player;
    }

    AbstractPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    Player getPlayer() {
        return player;
    }

    ArtificialPlayer getBot() {
        return bot;
    }

    Board getBoard() {
        return board;
    }

    void setCurrentPlayer(AbstractPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}