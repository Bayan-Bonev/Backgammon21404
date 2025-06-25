package game_objects;

import java.util.Arrays;
import java.util.Stack;

public class Board implements IGameObject {

    private Stack<Piece>[][] board;

    Board() {
        this.board = new Stack[2][12];
    }

    public void addPiece(boolean isWhite, int x, int y, int n, int direction) {
        for (int i = 0; i < n; i++) {
            this.board[y][x].push(new Piece(isWhite, x, y));
        }
    }

    boolean isVulnerable(int x, int y) {
        return board[y][x].size() < 2;
    }

    /*int getUnavailablePositionsInStartingBoard(boolean isWhite){
        int posCounter = 0;
        int y = (isWhite)? 0:1;

        for (int x = 6; x < 12; x++) {
            if(!board[y][x].isEmpty()) {
                posCounter++;
            }
        }
        return posCounter;
    }

    Piece[] findBlots(boolean isWhite) {
        ArrayList<Piece> blots = new ArrayList<>();
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 12; x++) {
                if (!(board[y][x].isEmpty()) && isVulnerable(x, y)) {
                    blots.add(board[y][x].peek());
                }
            }
        }
        blots.trimToSize();
        return blots.toArray(new Piece[0]);
    }

    /*public int[] validMoves(int x, int y, int[] dice, boolean isWhite, Player currentPlayer) {
        int[] validMoves = new int[dice.length];
        if (currentPlayer.getCapturedByOpponent()[0] == null) {
            for (int i = 0; i < dice.length; i++) {
                if (Utils.isVulnerable(board, (x + dice[i]), y)) {
                    validMoves[i] = dice[i];
                }
            }
        }
        else {
            int yOfStartingBoard = (isWhite)? 0 : 1;
            for (int xPos = 6; x < 12; x++) {
                for (int dieValue : dice) {
                    if (isVulnerable(x, y)) {
                        for (int i = 0; i < validMoves.length; i++) {
                            if (validMoves[i] == 0) {
                                validMoves[i] = dieValue;
                            }
                        }
                    }
                }
            }
        }
        return validMoves;
    }*/


    @Override
    public String toString() {
        return Arrays.toString(board);
    }

}
