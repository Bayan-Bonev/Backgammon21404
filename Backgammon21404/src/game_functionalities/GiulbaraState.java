package game_functionalities;

public class GiulbaraState extends Game implements State{

    public static GiulbaraState INSTANCE;

    @Override
    void arrangeBoard() {

    }

    @Override
    void movePiece() {

    }

    @Override
    boolean canMove() {
        return false;
    }

    @Override
    boolean isVulnerable(int x, int y) {
        return false;
    }

    public static GiulbaraState getINSTANCE() {
        return (INSTANCE==null)? new GiulbaraState(): INSTANCE;
    }
}