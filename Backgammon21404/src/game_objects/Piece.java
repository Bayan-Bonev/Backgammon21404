package game_objects;

import game_functionalities.GameContext;

public class Piece {

    private final boolean isWhite;
    private int x;
    private int y;
    private int direction;
    private int spacesTravelled;

    public Piece(boolean isWhite, int x, int y) {
        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
        setDirection();
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public void setDirection() {
        this.direction = GameContext.currentState.determineDirection(isWhite, y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}