package game_functionalities;

import game_objects.Board;

public class TapaStrategy extends Game implements GameStrategy {

    static TapaStrategy INSTANCE;

    TapaStrategy() {
        super();
    }

    @Override
    public Board arrangeBoard() {
        Board board = new Board();
        board.addPiece(true, 0, 0, 15);
        board.addPiece(true, 0, 1, 15);
        GameContext.setBoard(board);
        return board;
    }

    @Override
    public int determineDirection(boolean isWhite, int y) {
        return (y == 0) ? -1 : 1;
    }

    @Override
    public boolean isVulnerable(Board b, int x, int y) {
        return b.isBlot(x, y) || this.getBoard().isEmpty(x, y);
    }

    @Override
    public int[] getOuterBoardIndices( boolean isWhite) {  // Gets the board quadrant where the player starts.
        return new int[]{
                isWhite? 6 : 11, //upper bound of x
                isWhite? 0 : 1   //y
        };
    }

    @Override
    public int[] getHomeBoardIndices(boolean isWhite) {
        return getOuterBoardIndices( !(isWhite));
    }

    public static TapaStrategy getINSTANCE() {
        return (INSTANCE==null)? new TapaStrategy():INSTANCE;
    }

}
