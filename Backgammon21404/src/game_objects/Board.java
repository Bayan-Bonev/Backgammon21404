package game_objects;

import game_functionalities.GameContext;
import game_functionalities.GameStrategy;
import gui.BoardPosition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Board implements IGameObject {

    public static final HashMap<BoardPosition, Integer> STACK_SIZE_BY_IDX_WHITE = new HashMap<>();
    public static final HashMap<BoardPosition, Integer> STACK_SIZE_BY_IDX_BLACK = new HashMap<>();
    public static void incrementStackSize(BoardPosition position, boolean isWhite) {
        if (isWhite) {
            STACK_SIZE_BY_IDX_WHITE.put(position, STACK_SIZE_BY_IDX_WHITE.getOrDefault(position, 0) + 1);
        } else {
            STACK_SIZE_BY_IDX_BLACK.put(position, STACK_SIZE_BY_IDX_BLACK.getOrDefault(position, 0) + 1);
        }
    }

    public static int getStackSize(BoardPosition position, boolean isWhite) {
        return isWhite? STACK_SIZE_BY_IDX_WHITE.getOrDefault(position, 0) : STACK_SIZE_BY_IDX_BLACK.getOrDefault(position, 0);
    }

    public static HashMap<BoardPosition, Integer> getStackSizeMap(boolean isWhite) {
        return isWhite? STACK_SIZE_BY_IDX_WHITE : STACK_SIZE_BY_IDX_BLACK;
    }

    private Stack<Piece>[][] board;

    public Board() {
        this.board = new Stack[2][12];
    }

    public void addPiece(boolean isWhite, int x, int y, int n, int direction) {
        for (int i = 0; i < n; i++) {
            this.board[y][x].push(new Piece(isWhite, x, y));
            if (isWhite) {
                STACK_SIZE_BY_IDX_WHITE.put(new BoardPosition(x, y), n + 1);
            } else {
                STACK_SIZE_BY_IDX_BLACK.put(new BoardPosition(x, y), n + 1);
            }
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