package utilities.board_logic_utilities;

import game_functionalities.GameContext;
import game_functionalities.State;
import game_objects.Board;
import game_objects.Piece;

import java.util.ArrayList;

public class MoveEvaluator extends MoveAgent{

    RewardCalculator rewardCalculator;
    RiskCalculator riskCalculator;

    MoveEvaluator() {
        this.rewardCalculator = new RewardCalculator();
        this.riskCalculator = new RiskCalculator();
    }

    public double evaluate(Move move) {
        return rewardCalculator.calcReward(move)/riskCalculator.calcRisk(GameContext.getCurrentPlayer().isWhite());
    }

    static Piece[] findBlots(boolean isWhite) {
        Board board = GameContext.getBoard();
        State currentState = GameContext.getState();
        ArrayList<Piece> blots = new ArrayList<>();
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 12; x++) {
                if (!(board.isEmpty(x, y)) && currentState.isVulnerable(x, y) && isWhite) {
                    blots.add(board.getByIdx(x, y).peek());
                }
            }
        }
        blots.trimToSize();
        return blots.toArray(new Piece[0]);
    }
}