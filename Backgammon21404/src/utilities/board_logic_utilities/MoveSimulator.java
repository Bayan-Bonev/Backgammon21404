package utilities.board_logic_utilities;

import java.util.HashMap;
import game_functionalities.GameContext;
import game_objects.Piece;

import java.util.*;

public class MoveSimulator extends MoveAgent {

    MoveSimulator() {
        super();
    }

    public HashMap<Integer, List<Move>> simulatePossibleMoves(){
        MoveValidator validator = new MoveValidator();
        HashMap<Integer, List<Move>> possibleMoves = new HashMap<>();
        Stack<Piece>[][] boardAsMatrix = GameContext.getBoard().getBoard();
        List<Move> movesPerDieValue = new ArrayList<>();
        int[] dice = GameContext.getCurrentPlayer().getDice();
        int x1, y1, x2, y2;
        Move move;

        for (y1 = 0; y1 < boardAsMatrix.length; y1++) {
            for (x1 = 0; x1 < boardAsMatrix[y1].length; x1++) {
                for (int dieValue : dice) {
                    move = new Move(x1, y1, dice[dieValue]);
                    if (validator.isValid(move)) {
                        movesPerDieValue.add(move);
                    }
                }
            }
        }
        return possibleMoves;
    }
}