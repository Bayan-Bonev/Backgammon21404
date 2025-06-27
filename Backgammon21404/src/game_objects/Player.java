package game_objects;

public class Player extends AbstractPlayer {

    Player() {
        super();
    }

    Player(boolean isWhite) {
        super(isWhite);
    }

    public boolean hasDieValue(int dieValue) {
        int dice[] = this.getDice();
        for (int d : dice) {
            if (d == dieValue) {
                return true;
            }
        }
        return false;
    }

}
