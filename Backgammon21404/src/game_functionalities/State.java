package game_functionalities;

import utilities.board_logic_utilities.Move;

public interface State {

    boolean isVulnerable(int x, int y);
    void arrangeBoard();
    int[] getOuterBoardIndices(boolean isWhite);
    int[] getHomeBoardIndices(boolean isWhite);

}
