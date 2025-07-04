package utilities.board_logic_utilities;

import game_functionalities.GameContext;
import game_objects.Board;

public class RewardCalculator {

    double calcReward(Move move) {
        double reward = 0.0;

        reward += calcAdvanceReward(move);
        reward += isBearingOff(move)? getBearingOffReward(move):0;
        reward += isHittingOpponentBlot(move)? getHitReward(move):0;

        return reward;
    }

    private double calcAdvanceReward(Move move) {
        // Higher reward for moving a piece closer to bearing off
        int startDistance = getHomeDistance(move.getX1(), move.getY1());
        int endDistance = getHomeDistance(move.getX2(), move.getY2());
        return (startDistance - endDistance) * 1.0; // 1.0 is a weight, adjust as needed
    }

    private boolean isBearingOff(Move move) {
        // Implement logic based on your board representation
        // Example: check if x2/y2 is off the board for the current player
        return (move.getX2() < 0 || move.getX2() > 11); // Adjust as per your board limits
    }

    private double getBearingOffReward(Move move) {
        return 10.0; // Arbitrary positive reward, adjust as needed
    }

    private boolean isHittingOpponentBlot(Move move) {
        Board board = GameContext.getBoard();
        boolean opponentBlot = board.isBlot(move.getX2(), move.getY2()) &&
                board.isWhite(move.getX2(), move.getY2()) != GameContext.getCurrentPlayer().isWhite();
        return opponentBlot;
    }

    private double getHitReward(Move move) {
        return 5.0;
    }


    private int getHomeDistance(int x, int y) {
        boolean isWhite = GameContext.getCurrentPlayer().isWhite();
        if (isWhite) {
            return x;
        } else {
            return 11 - x;
        }
    }

}
