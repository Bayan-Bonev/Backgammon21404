package game_objects;


import java.util.Random;

public abstract class AbstractPlayer implements IGameObject {

    private static final Random random = new Random();

    private boolean isWhite;
    private int[] dice;
    private int turnsLeft;

    public AbstractPlayer() {
    }

    AbstractPlayer(boolean isWhite) {
        this.setWhite(isWhite);
        this.setDice(null);
        this.setTurnsLeft(0);
    }

    void rollDice() {
        int d1 = random.nextInt(1, 6);
        int d2 = random.nextInt(1, 6);
        this.setDice((d1==d2)? new int[]{d1, d2} : new int[]{d1,d1,d2,d2});
    }


    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public int[] getDice() {
        return dice;
    }

    public void setDice(int[] dice) {
        this.dice = dice;
    }

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public void setTurnsLeft(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }
}
