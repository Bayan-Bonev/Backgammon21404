package game_functionalities;

import game_objects.Board;
import game_objects.GameObjectFactory;

public class GiulbaraState extends Game implements State {

    public static GiulbaraState INSTANCE;

    @Override
    public void arrangeBoard() {
        Board board = (Board) GameObjectFactory.createInstance("board");
        board.addPiece(true, 11, 0, 15, -1);
        board.addPiece(true, 0, 1, 15, -1);
        this.setBoard(board);
    }

    @Override
    public void movePiece() {

    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean isVulnerable(int x, int y) {
        return this.getBoard().isEmpty(x, y);
    }

    public int[] getOuterBoardIndices() {
        boolean isWhite = GameContext.getPlayer().isWhite();
        return new int[] {
                isWhite? 6:0, //x
                isWhite? 0:1  //y
        };
    }

    public static GiulbaraState getINSTANCE() {
        return (INSTANCE==null)? new GiulbaraState(): INSTANCE;
    }
}