package utilities.board_logic_utilities;

import game_functionalities.GameContext;
import game_functionalities.State;
import game_objects.Piece;
import java.util.Arrays;

public class RiskCalculator extends MoveAgent {

    RiskCalculator() {
        super();
    }

    RiskCalculator(State state) {
        super(state);
    }

    double calcRisk(boolean isWhite) {
        Piece[] blots = MoveEvaluator.findBlots(isWhite);
        int[] dice = GameContext.getCurrentPlayer().getDice();
        int risk = ((Math.round((float) countOpeningsInOuterBoard() / 36)) * blots.length);
        for (Piece blot : blots) {
            risk += calcBlotVulnerability(blot.getX(), blot.getY());
        }
        return risk;
    }

    private int countOpeningsInOuterBoard() {
        boolean isWhite = GameContext.getCurrentPlayer().isWhite();
        int[] searchRadius = GameContext.getState().getOuterBoardIndices(isWhite);

        int openings = 0;

        for (int x = searchRadius[0]; x < searchRadius[1]; x++) {
            if (GameContext.getState().isVulnerable(x, searchRadius[3])) {
                openings++;
            }
        }
        return openings;
    }

    private int calcBlotVulnerability(int x, int y) {
        Piece blot = GameContext.getBoard().getByIdx(x, y).peek();
        boolean isWhite = GameContext.getBoard().isWhite(x, y);
        Move move;
        int[] dice = GameContext.getCurrentPlayer().getDice();
        int vulnerability = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 12; j++) {
                for (int dieValue : dice) {
                    move = new Move(i, j, dieValue);
                    if (isWhite != blot.isWhite()
                            && Arrays.equals(move.determineIndicesAfterMove(x, y, dieValue), new int[]{x, y})) {
                        vulnerability++;
                    }
                }
            }
        }
        return vulnerability;
    }
}