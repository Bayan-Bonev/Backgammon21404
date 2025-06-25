package game_functionalities;

import game_objects.GameObjectFactory;
import game_objects.Player;

public class TapaState extends Game implements State{

    public static TapaState INSTANCE;

    private TapaState() {
        super((Player)GameObjectFactory.createInstance("Player"));
    }

    @Override
    void arrangeBoard() { //todo

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

    public static TapaState getINSTANCE() {
        return (INSTANCE==null)? new TapaState():INSTANCE;
    }

}
