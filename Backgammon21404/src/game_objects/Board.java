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

    public Stack<Piece>[][] getBoard() {
        return this.board;
    }
}