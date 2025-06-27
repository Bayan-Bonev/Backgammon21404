package game_functionalities;

import game_objects.*;
import utilities.board_logic_utilities.*;

import java.util.Stack;

public abstract class Game {

    static final MoveValidator validator = (MoveValidator) MoveAgentFactory.createInstance("validator");

    private Board board;
    public AbstractPlayer currentPlayer;
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

    public void movePiece(Move move) {
        if (Game.validator.isValid(move) && canMove()) {
            Stack<Piece>[][] board = GameContext.getBoard().getBoard();
            board[move.getX2()][move.getY2()].push(
                    board[move.getY1()][move.getX1()].pop()
            );
            Board boardAfterMove = (Board) GameObjectFactory.createInstance("Board");
            GameContext.setBoard(boardAfterMove);
        }
    }

    public boolean canMove() {
        return (GameContext.getCurrentPlayer().capturedIsEmpty());
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