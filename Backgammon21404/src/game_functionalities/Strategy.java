package game_functionalities;

public interface Strategy {

    boolean isVulnerable(int x, int y);
    void arrangeBoard();
    int[] getOuterBoardIndices(boolean isWhite);
    int[] getHomeBoardIndices(boolean isWhite);

}
