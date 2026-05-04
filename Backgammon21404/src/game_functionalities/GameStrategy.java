package game_functionalities;

import game_objects.Board;

import utilities.board_logic_utilities.Move;

public interface GameStrategy {

    boolean isVulnerable(Board board, int x, int y);
    Board arrangeBoard();
    int[] getOuterBoardIndices(boolean isWhite);
    int[] getHomeBoardIndices(boolean isWhite);
    int determineDirection(boolean isWhite, int y);
}
