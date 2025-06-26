package game_functionalities;

public interface State {

    boolean canMove();
    boolean isVulnerable(int x, int y);
    void arrangeBoard();
    void movePiece();
    int[] getOuterBoardIndices(boolean isWhite);
    int[] getHomeBoardIndices(boolean isWhite);

}
