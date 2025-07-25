package game_objects;

public class Piece {

    private final boolean isWhite;
    private int x;
    private int y;
    private int direction;
    private int spacesTravelled;

    Piece(boolean isWhite, int x, int y) {
        this.isWhite = isWhite;
        this.x = x;
        this.y = y;
        this.direction = findDirection();
    }

    private int findDirection() {
        int colourFactor = isWhite? 1:-1;
        int positionFactor = y==0? -1:1;
        return (colourFactor * positionFactor);
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public void setDirection() {
        this.direction = findDirection();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    void setX(int x) {
        this.x = x;
    }

    void setY(int y) {
        this.y = y;
    }

}