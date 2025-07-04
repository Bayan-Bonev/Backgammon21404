package utilities.board_logic_utilities;

import game_functionalities.*;

public class MoveValidator extends MoveAgent {

    MoveValidator() {}

    public boolean isValid(Move move) {
        State state = GameContext.getState();
        boolean currentPlayerIsWhite = GameContext.getCurrentPlayer().isWhite();
        int x1 = move.getX1();
        int x2 = move.getX2();
        int y1 = move.getY1();
        int y2 = move.getY2();

        return (!GameContext.getBoard().isEmpty(x1, y1)
                && currentPlayerIsWhite == GameContext.getBoard().isWhite(x1, y1)
                && (super.getState().isVulnerable(x2, y2)
                || currentPlayerIsWhite == GameContext.getBoard().isWhite(x2, y2)));
    }
}
