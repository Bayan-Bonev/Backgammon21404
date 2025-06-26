package game_objects;

import game_functionalities.State;
import utilities.board_logic_utilities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ArtificialPlayer extends AbstractPlayer {

    private static Move[] possibleMoves;

    private State currentState;
    public static MoveValidator validator = (MoveValidator) MoveAgentFactory.createInstance("validator");
    public static MoveEvaluator evaluator = (MoveEvaluator) MoveAgentFactory.createInstance("evaluator");
    public static MoveSimulator simulator = (MoveSimulator) MoveAgentFactory.createInstance("simulator");

    ArtificialPlayer() {
        super();
    }

    ArtificialPlayer(State state) {
        validator.setState(state);
        evaluator.setState(state);
        simulator.setState(state);
    }

    public Move play() {
        possibleMoves = (Move[])simulator.simulatePossibleMoves().toArray();
        setRiskPerMove();
        double totalRewardToRiskRatio = sumRewardToRiskRatio();

        return decide();
    }

    void setRiskPerMove() {
        for (Move m : possibleMoves) {
            m.setRewardToRiskRatio(evaluator.evaluate(m));
        }
    }

    private static double sumRewardToRiskRatio() {
        double total = 0;
        for (Move m : possibleMoves) {
            total += m.getRewardToRiskRatio();
        }
        return total;
    }

    private static Move decide() {
        double totalWeight = sumRewardToRiskRatio();
        double decision = Math.random() * totalWeight;
        double weightSoFar = 0;
        for (Move m : possibleMoves) {
            weightSoFar += m.getRewardToRiskRatio();
            if (decision >= weightSoFar) {
                return m;
            }
        }
        return possibleMoves[possibleMoves.length - 1];
    }

    public void setState(State state) {
        this.currentState = state;
    }
    
}
