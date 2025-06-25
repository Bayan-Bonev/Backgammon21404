package utilities.board_logic_utilities;

import game_functionalities.BackgammonState;
import game_functionalities.GameContext;
import game_functionalities.GiulbaraState;
import game_functionalities.State;
import game_objects.Piece;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class MoveEvaluator extends MoveAgent {

    MoveEvaluator() {
        super();
    }

    MoveEvaluator(State state) {
        super(state);
    }

    static double evaluate(Move move) {
        return 0.0;
    }
    private double calcRisk() {
        boolean isWhite = GameContext.getCurrentPlayer().isWhite();

        Piece[] blots = findBlots(isWhite);
        int risk = ((Math.round((float) countOpeningsInStartingBoard(isWhite) / 36)) * blots.length);
        for (Piece blot : blots) {
            risk += calcBlotVulnerability(blot, dice);
        }
        return risk;
    }

    private int countOpeningsInStartingBoard() {
        boolean isWhite = GameContext.getCurrentPlayer().isWhite();
        int[] searchRadius = findSearchRadiusForStartingBoard();

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
                            && Arrays.equals(move.determineIndicesAfterMove(x, y, dieValue), new int[]{x, y}) {
                        vulnerability++;
                    }
                }
            }
        }
        return vulnerability;
    }

    private int[] findSearchRadiusForStartingBoard() {
        boolean isWhite = GameContext.getCurrentPlayer().isWhite();

        return new int[]{
                isWhite? 6 : 0,
                isWhite? 11: 6,
                isWhite? 0 : 1
        };
    }

    private double calcReward() {
        return 0.0;
    }
}