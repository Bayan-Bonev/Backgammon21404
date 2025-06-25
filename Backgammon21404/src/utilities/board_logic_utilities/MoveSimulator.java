package utilities.board_logic_utilities;

import game_functionalities.GameContext;
import game_objects.Board;
import game_objects.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MoveSimulator extends MoveAgent {

    MoveSimulator() {
        super();
    }

    ArrayList<Move> simulatePossibleMoves(){
        MoveValidator validator = new MoveValidator();
        ArrayList<Move> possibleMoves = new ArrayList<>();
        Stack<Piece>[][] boardAsMatrix = GameContext.getBoard().getBoard();
        int[] dice = GameContext.getCurrentPlayer().getDice();
        int x1, y1, x2, y2;
        Move move;

        for (y1 = 0; y1 < boardAsMatrix.length; y1++) {
            for (x1 = 0; x1 < boardAsMatrix[y1].length; x1++) {
                for (int dieValue : dice) {
                    move = new Move(x1, y1, dice[dieValue]);
                    if (validator.isValid(move)) {
                        possibleMoves.add(move);
                    }

                }
            }
        }
        return possibleMoves;
    }
}