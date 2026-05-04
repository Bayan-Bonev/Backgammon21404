package game_functionalities;

import game_objects.*;
import gui.BoardPosition;
import utilities.board_logic_utilities.*;

import java.util.Stack;

public abstract class  Game {

    private Board board;
    public AbstractPlayer currentPlayer;
    private Player player;
    private ArtificialPlayer bot;

    Game() {
        this.setBoard(new Board());
    }

    Game(AbstractPlayer currentPlayer) {
        this.setCurrentPlayer(currentPlayer);
        this.player = (currentPlayer instanceof Player)?
                (Player)currentPlayer:
                new Player();
        this.bot = (currentPlayer instanceof ArtificialPlayer)?
                (ArtificialPlayer) currentPlayer :
                new ArtificialPlayer(ArtificialPlayer.Difficulty.EASY);
        this.setBoard(new Board());
    }

    public static void movePiece(Move move) {
        BoardPosition inital = new BoardPosition(move.getX1(), move.getY1());
        BoardPosition target = new BoardPosition(move.getX2(), move.getY2());
        boolean isWhite = GameContext.getBoard().isWhite(move.getX1(), move.getY1());

        if (move.isValid() && canMove()) {
            GameContext.getBoard().getBoard()[move.getX2()][move.getY2()].push(
                    GameContext.getBoard().getBoard()[move.getY1()][move.getX1()].pop());
            if (isWhite) {
            Board.incrementStackSize(target, isWhite);
            } else {
                Board.STACK_SIZE_BY_IDX_BLACK.put(new BoardPosition(move.getX1(), move.getY1()),
                        GameContext.getBoard().getBoard()[move.getY1()][move.getX1()].size());
            }
        }
    }

    public static boolean canMove() {
        return (GameContext.getCurrentPlayer().capturedIsEmpty());
    }

    public void switchPlayer() {
        this.currentPlayer = (currentPlayer instanceof Player)? this.bot:this.player;
    }

    public AbstractPlayer getCurrentPlayer() {
        return currentPlayer;
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

    public Board getBoard() {
        return board;
    }

    void setCurrentPlayer(AbstractPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}