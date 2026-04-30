package game_functionalities;

import java.util.HashMap;

public interface GameStrategy {

    boolean isVulnerable(int x, int y);
    void arrangeBoard();
    int[] getOuterBoardIndices(boolean isWhite);
    int[] getHomeBoardIndices(boolean isWhite);
    int determineDirection(boolean isWhite, int y);
}
