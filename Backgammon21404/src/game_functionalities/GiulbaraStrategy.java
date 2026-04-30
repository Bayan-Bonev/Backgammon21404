package game_functionalities;

import game_objects.Board;

public class GiulbaraStrategy extends Game implements GameStrategy {

    static GiulbaraStrategy INSTANCE;

    @Override
    public void arrangeBoard() {
        Board board = new Board();
        board.addPiece(true, 11, 0, 15);
        board.addPiece(true, 0, 1, 15);
        this.setBoard(board);
    }

    /*@Override
    public void movePiece(int fromX, int fromY, int toX, int toY) {
        this.getBoard().getByIdx(fromX, fromY).pop().setX(toX);
        this.getBoard().getByIdx(fromX, fromY).pop().setY(toY);
    }*/

    @Override
    public int determineDirection(boolean isWhite, int y) {
        return (y == 0) ? -1 : 1 * (isWhite? 1:-1);
    }

    @Override
    public boolean isVulnerable(int x, int y) {
        return this.getBoard().isEmpty(x, y);
    }

    @Override
    public int[] getOuterBoardIndices(boolean isWhite) {
        return new int[] {
                isWhite? 6:0, //x
                isWhite? 0:1  //y
        };
    }

    @Override
    public int[] getHomeBoardIndices(boolean isWhite) {
        return new int[] {
                isWhite? 6:11,//upper bound of x
                isWhite? 0:1  //y
        };
    }

    public static GiulbaraStrategy getINSTANCE() {
        return (INSTANCE==null)? new GiulbaraStrategy(): INSTANCE;
    }
}