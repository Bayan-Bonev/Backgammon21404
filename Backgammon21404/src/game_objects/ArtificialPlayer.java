package game_objects;

import game_functionalities.GameContext;
import game_functionalities.State;
import utilities.board_logic_utilities.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class ArtificialPlayer extends AbstractPlayer {

    private static HashMap<Integer, Move> movesPerDie;
    static final MoveValidator validator = (MoveValidator) MoveAgentFactory.createInstance("validator");
    static final MoveEvaluator evaluator = (MoveEvaluator) MoveAgentFactory.createInstance("evaluator");
    static final MoveSimulator simulator = (MoveSimulator) MoveAgentFactory.createInstance("simulator");

    private State currentState;

    ArtificialPlayer() {
        super();
        validator.setState(GameContext.getState());
        evaluator.setState(GameContext.getState());
        simulator.setState(GameContext.getState());
    }

    ArtificialPlayer(State state) {
        validator.setState(state);
        evaluator.setState(state);
        simulator.setState(state);
    }

    public Move play() {
        movesPerDie= simulator.simulatePossibleMoves();
        setRiskPerMove();
        double totalRewardToRiskRatio = sumRewardToRiskRatio();

        return decide();
    }

    void setRiskPerMove() {
        for (Move m : movesPerDie.keySet().toArray()) {
            m.setRewardToRiskRatio(evaluator.evaluate(m));
        }
    }

    private static double sumRewardToRiskRatio() {
        double total = 0;
        for (Move m : movesPerDie.keySet()) {
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
