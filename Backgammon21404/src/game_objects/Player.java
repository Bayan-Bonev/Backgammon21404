package game_objects;

public class Player extends AbstractPlayer {

    private boolean isWhite;
    private int[] dice;
    private int turnsLeft;

    Player() {
        super();
    }

    Player(boolean isWhite) {
        super(isWhite);
    }

}
