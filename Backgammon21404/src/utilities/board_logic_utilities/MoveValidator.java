package utilities.board_logic_utilities;

import game_functionalities.*;
import utilities.exceptions.InvalidMoveException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class MoveValidator extends MoveAgent {

    MoveValidator() {
        super();
    }

    public boolean isValid(Move move) {
        State state = GameContext.getState();
        boolean currentPlayerIsWhite = GameContext.getCurrentPlayer().isWhite();
        int x1 = move.getX1();
        int x2 = move.getX2();
        int y1 = move.getY1();
        int y2 = move.getY2();

        return (!board.isEmpty(x1, y1)
                && currentPlayerIsWhite == board.isWhite(x1, y1)
                && (super.getState().isVulnerable(x2, y2)
                || currentPlayerIsWhite == board.isWhite(x2, y2)));
    }
}
