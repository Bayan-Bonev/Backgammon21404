package utilities.board_logic_utilities;

import game_functionalities.*;
import game_objects.Board;
import game_objects.Piece;

import java.util.Arrays;
import java.util.Stack;

public class MoveValidator extends MoveAgent {

    MoveValidator() {
        super();
    }

    public boolean isValid(Move move) {
        boolean currentPlayerIsWhite = GameContext.getCurrentPlayer().isWhite();
        int x1 = move.getX1();
        int x2 = move.getX2();
        int y1 = move.getY1();
        int y2 = move.getY2();

        return (!board.isEmpty(x1, y1)
                && currentPlayerIsWhite == board.isWhite(x1, y1)
                &&
                (super.getState().isVulnerable(x2, y2)
                        || currentPlayerIsWhite == board.isWhite(x2, y2))
        );
    }
}
