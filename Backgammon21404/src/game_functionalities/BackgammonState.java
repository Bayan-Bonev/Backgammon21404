package game_functionalities;

import game_objects.Board;
import game_objects.GameObjectFactory;

public class BackgammonState extends Game implements State {

    static BackgammonState INSTANCE;
    static State CURRENTSTATE;

    BackgammonState() {
        super();
    }

    @Override
    public void arrangeBoard() {
        Board board = (Board)GameObjectFactory.createInstance("Board");

        board.addPiece(true, 11, 0, 2, -1);
        board.addPiece(true, 0,  0, 5, -1);
        board.addPiece(true, 4,  1, 3, 1);
        board.addPiece(true, 6,  1, 5, 1);

        board.addPiece(false, 11, 1, 2, -1);
        board.addPiece(false, 0,  1, 5, -1);
        board.addPiece(false, 4,  0, 3, 1);
        board.addPiece(false, 6,  0, 5, 1);

        this.setBoard(board);
    }

    @Override
    public void movePiece() {
        //todo
    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean isVulnerable(int x, int y) {
        return this.getBoard().isBlot(x, y) || this.getBoard().isEmpty(x, y);
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

    public static BackgammonState getINSTANCE() {
        return (INSTANCE==null)? new BackgammonState() : INSTANCE;
    }

}