package utilities.board_logic_utilities;

import game_functionalities.State;
import game_objects.Board;

import java.util.List;

public class MoveSimulator<T extends State> {

    State currentState;

    MoveSimulator(State state) {
        this.currentState = state;
    }

    List<Board> simulatePossibleMoves() {

    }

}
