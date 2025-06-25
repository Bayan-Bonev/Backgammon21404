package game_objects;

import game_functionalities.GameContext;

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

    public boolean isBlot(int x, int y) {
        return board[y][x].size() == 1;
    }

    public boolean isEmpty(int x, int y) {
        return board[y][x].isEmpty();
    }

    public boolean isWhite(int x, int y) {
        return board[y][x].peek().isWhite();
    }

    public Stack<Piece> getByIdx(int x, int y) {
        return board[y][x];
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

    @Override
    public String toString() {
        return Arrays.toString(board);
    }

    public Stack<Piece>[][] getBoard() {
        return this.board;
    }

}
