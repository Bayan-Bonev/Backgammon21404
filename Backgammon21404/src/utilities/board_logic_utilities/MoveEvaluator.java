package utilities.board_logic_utilities;

import game_functionalities.State;

public class MoveEvaluator<T extends State> extends MoveAgent {

    MoveEvaluator(State state) {
        super(state);
    }

    static double evaluate(Move move) {

    }
    private static double calcRisk(Move move) {
        return 0.0;
    }

    private static double calcReward(Move move) {
        return 0.0;
    }

}
