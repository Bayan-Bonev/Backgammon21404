package utilities.board_logic_utilities;

import game_functionalities.GameContext;
import game_functionalities.State;
import game_objects.Board;
import game_objects.GameObjectFactory;
import game_objects.Piece;

import java.util.Stack;

public abstract class MoveAgent {
    Move move;
    State currentState;

    MoveAgent() {}

    MoveAgent(State state) {
        this.currentState = state;
    }

    public void setState(State state) {
        currentState = state;
    }

    State getState() {
        return currentState;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}