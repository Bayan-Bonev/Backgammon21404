package utilities.board_logic_utilities;

import game_functionalities.GameStrategy;

public abstract class MoveAgent {
    Move move;
    GameStrategy currentState;

    MoveAgent() {}

    MoveAgent(GameStrategy state) {
        this.currentState = state;
    }

    public void setState(GameStrategy state) {
        currentState = state;
    }

    GameStrategy getState() {
        return currentState;
    }

    public void setMove(Move move) {
        this.move = move;
    }
}