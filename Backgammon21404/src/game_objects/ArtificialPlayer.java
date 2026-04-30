package game_objects;

import game_functionalities.GameContext;
import game_functionalities.GameStrategy;
import utilities.board_logic_utilities.*;

import java.util.*;

public class ArtificialPlayer extends AbstractPlayer {

    private static HashMap<Integer, List<Move>> movesPerDie;
    private static final MoveValidator validator = new MoveValidator();
    private static final MoveEvaluator evaluator = new MoveEvaluator();
    private static final MoveSimulator simulator = new MoveSimulator();

    private Difficulty difficulty;
    public enum Difficulty {
        EASY(1.0),
        MEDIUM(1.2),
        HARD(1.4);
        private double weightMultiplier;
        Difficulty(double weightMultiplier) {
            this.weightMultiplier = weightMultiplier;
        }
    }

    public ArtificialPlayer(Difficulty difficulty) {
        super();
        validator.setState(GameContext.getState());
        evaluator.setState(GameContext.getState());
        simulator.setState(GameContext.getState());
    }

    ArtificialPlayer(GameStrategy state) {
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
                m.setRiskRewardRatio(evaluator.evaluate(m));
            }
        }
    }

    private static double sumRewardToRiskRatio() {
        double total = 0;
        for (List<Move> moves : movesPerDie.values()) {
            for (Move m : moves) {
                total += m.getRiskRewardRatio();
            }
        }
        return total;
    }

    private static Move decide() {
        final double totalWeight = sumRewardToRiskRatio();
        final double decision = Math.random() * totalWeight;
        double weightSoFar = 0;
        for (List<Move> moves : movesPerDie.values()) {
            for (Move m : moves) {
                weightSoFar += m.getRiskRewardRatio();
                if (decision <= weightSoFar) {
                    return m;
                }
            }
        }
        return null;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

}