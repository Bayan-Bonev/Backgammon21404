package game_objects;

import game_functionalities.GameContext;
import game_functionalities.State;
import utilities.board_logic_utilities.*;

import java.util.*;

public class ArtificialPlayer extends AbstractPlayer {

    private static HashMap<Integer, List<Move>> movesPerDie;
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
        movesPerDie = simulator.simulatePossibleMoves();
        setRiskPerMove();
        double totalRewardToRiskRatio = sumRewardToRiskRatio();

        Move m = decide();
        movesPerDie.remove(movesPerDie.get(m)); // осигурява че никой зар няма да се играе повече от веднъж.

        return m;
    }

    void setRiskPerMove() {
        for (List<Move> moves : movesPerDie.values()) {
            for (Move m : moves) {
                m.setRewardToRiskRatio(evaluator.evaluate(m));
            }
        }
    }

    private static double sumRewardToRiskRatio() {
        double total = 0;
        for (List<Move> moves : movesPerDie.values()) {
            for (Move m : moves) {
                total += m.getRewardToRiskRatio();
            }
        }
        return total;
    }

    private static Move decide() {
        double totalWeight = sumRewardToRiskRatio();
        double decision = Math.random() * totalWeight;
        double weightSoFar = 0;
        for (List<Move> moves : movesPerDie.values()) {
            for (Move m : moves) {
                weightSoFar += m.getRewardToRiskRatio();
                if (decision <= weightSoFar) {
                    return m;
                }
            }
        }
        return null;
    }

    public void setState(State state) {
        this.currentState = state;
    }
}