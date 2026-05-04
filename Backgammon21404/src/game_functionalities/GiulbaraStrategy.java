package game_functionalities;

import game_objects.Board;
import utilities.board_logic_utilities.Move;

public class GiulbaraStrategy implements GameStrategy {

    static GiulbaraStrategy INSTANCE;

    @Override
    public Board arrangeBoard() {
        Board board = new Board();
        board.addPiece(true, 11, 0, 15);
        board.addPiece(true, 0, 1, 15);
        return board;
    }

    public void movePiece(Move m) {
        Board b = GameContext.getBoard();

    }

    @Override
    public int determineDirection(boolean isWhite, int y) {
        return (y == 0) ? -1 : 1 * (isWhite? 1:-1);
    }

    @Override
    public boolean isVulnerable(Board board, int x, int y) {
        return board.isEmpty(x, y);
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