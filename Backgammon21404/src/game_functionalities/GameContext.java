package game_functionalities;

import game_objects.*;
import utilities.board_logic_utilities.Move;

import java.util.Stack;

public class GameContext {

    public static Game gameInstance;
    public static State currentState;

    public GameContext(State currentState) {
        currentState = currentState;
    }

    public State getCurrentState() {
        if (currentState instanceof TablaState) {
            return TablaState.getINSTANCE();
        }
        else if(currentState instanceof GiulbaraState) {
            return GiulbaraState.getINSTANCE();
        }
        else {
            return TapaState.getINSTANCE();
        }
    }

    public static void movePiece(Move move) {
        gameInstance.movePiece(move);
    }

    public boolean canMove() {
        return (GameContext.getCurrentPlayer().capturedIsEmpty());
    }

    public static Board getBoard() {
        return gameInstance.getBoard();
    }

    public static void setBoard(Board board) {
        gameInstance.setBoard(board);
    }

    public static AbstractPlayer getCurrentPlayer() {
        return gameInstance.getCurrentPlayer();
    }

    public static Player getPlayer() {
        return gameInstance.getPlayer();
    }

    public static ArtificialPlayer getBot() {
        return gameInstance.getBot();
    }

    public static State getState() {
        return getState();
    }
}