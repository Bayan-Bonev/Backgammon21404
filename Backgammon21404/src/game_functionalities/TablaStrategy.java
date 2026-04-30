package game_functionalities;

import game_objects.Board;

public class TablaStrategy extends Game implements GameStrategy {

    static TablaStrategy INSTANCE;

    TablaStrategy() {
        super();
    }

    @Override
    public void arrangeBoard() {
        Board board = new Board();

        board.addPiece(true, 11, 0, 2);
        board.addPiece(true, 0, 0, 5);
        board.addPiece(true, 4, 1, 3);
        board.addPiece(true, 6, 1, 5);

        board.addPiece(false, 11, 1, 2);
        board.addPiece(false, 0, 1, 5);
        board.addPiece(false, 4, 0, 3);
        board.addPiece(false, 6, 0, 5);

        this.setBoard(board);
    }

    @Override
    public boolean isVulnerable(int x, int y) {
        return this.getBoard().isBlot(x, y) || this.getBoard().isEmpty(x, y);
    }

    @Override
    public int determineDirection(boolean isWhite, int y) {
        return (isWhite? 1:-1) * (y==0? 1:-1);
    }

    @Override
    public int[] getOuterBoardIndices( boolean isWhite) {  // Gets the board quadrant where the player starts.
        return new int[] {
                isWhite? 6 : 11, //upper bound of x
                isWhite? 0 : 1   //y
        };
    }

    @Override
    public int[] getHomeBoardIndices(boolean isWhite) {
        return getOuterBoardIndices( !(isWhite));
    }

    public static TablaStrategy getINSTANCE() {
        return (INSTANCE==null)? new TablaStrategy() : INSTANCE;
    }

}