package utilities.board_logic_utilities;

import game_functionalities.Strategy;

public abstract class MoveAgent {
    Move move;
    Strategy currentState;

    MoveAgent() {}

    MoveAgent(Strategy state) {
        this.currentState = state;
    }

    public void setState(Strategy state) {
        currentState = state;
    }

    Strategy getState() {
        return currentState;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}