package utilities.board_logic_utilities;

import game_functionalities.*;

import java.util.List;

public class Move<T extends State> {

    T state;
    int x1, y1;
    int x2, y2;
    double riskRewardRatio;
    List<Move<T>> possibleMoves;

    Move(T state, int x1, int y1, int y2) {
        this.state = state;
    }
}