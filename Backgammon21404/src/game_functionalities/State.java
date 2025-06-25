package game_functionalities;

public interface State {

    abstract boolean canMove();
    abstract boolean isVulnerable(int x, int y);
    abstract void arrangeBoard();
    abstract void movePiece();

}
