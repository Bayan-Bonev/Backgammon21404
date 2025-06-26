package utilities.board_logic_utilities;

import game_functionalities.BackgammonState;
import game_functionalities.GameContext;
import game_functionalities.GiulbaraState;
import game_functionalities.State;
import game_objects.Board;
import game_objects.Piece;

import java.util.ArrayList;
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

    private double calcReward(Move move) {
        return 0.0;
        //todo
    }

    private double calcRisk() {
        Piece[] blots = findBlots();
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

    private Piece[] findBlots() {
        Board board = GameContext.getBoard();
        State currentState = GameContext.getState();
        ArrayList<Piece> blots = new ArrayList<>();
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 12; x++) {
                if (!(board.isEmpty(x, y)) && currentState.isVulnerable(x, y)) {
                    blots.add(board.getByIdx(x, y).peek());
                }
            }
        }
        blots.trimToSize();
        return blots.toArray(new Piece[0]);
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

    private double calcReward() {
        return 0.0;
    }
}