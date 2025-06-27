package utilities.board_logic_utilities;

import java.util.HashMap;
import game_functionalities.GameContext;
import game_objects.Piece;

import java.util.*;

public class MoveSimulator extends MoveAgent {

    MoveSimulator() {
        super();
    }

    public HashMap<Integer, List<Move>> simulatePossibleMoves() {
        MoveValidator validator = new MoveValidator();
        HashMap<Integer, List<Move>> possibleMoves = new HashMap<>();
        Stack<Piece>[][] boardAsMatrix = GameContext.getBoard().getBoard();
        int[] dice = GameContext.getCurrentPlayer().getDice();

        for (int diceIdx = 0; diceIdx < dice.length; diceIdx++) {
            List<Move> movesPerDieValue = new ArrayList<>();
            for (int y1 = 0; y1 < boardAsMatrix.length; y1++) {
                for (int x1 = 0; x1 < boardAsMatrix[y1].length; x1++) {
                    Move move = new Move(x1, y1, dice[diceIdx]);
                    if (validator.isValid(move)) {
                        movesPerDieValue.add(move);
                    }
                }
            }
            possibleMoves.put(dice[diceIdx], movesPerDieValue);
        }
        return possibleMoves;
    }
}