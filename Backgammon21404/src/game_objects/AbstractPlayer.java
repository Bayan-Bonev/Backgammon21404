package game_objects;

import java.util.List;
import java.util.Random;
import java.util.Stack;

public abstract class AbstractPlayer implements IGameObject {

    private static final Random random = new Random();

    private boolean isWhite;
    private int[] dice;
    private int turnsLeft;
    private Stack<Piece> captured;
    private Stack<Piece> takenOut;

    public AbstractPlayer() {
    }

    AbstractPlayer(boolean isWhite) {
        this.setWhite(isWhite);
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

    public Stack<Piece> getCaptured() {
        return this.captured;
    }

    public void addToCaptured(Piece p) {
        this.captured.push(p);
    }

    public boolean capturedIsEmpty() {
        return this.captured.isEmpty();
    }

    public Piece removeFromCaptured() {
        return this.captured.pop();
    }

    public Stack<Piece> getTakenOut() {
        return this.takenOut;
    }

    public boolean takenOutIsEmpty() {
        return this.takenOut.isEmpty();
    }

    public void addToTakenOut(Piece p) {
        this.takenOut.add(p);
    }

    public Piece removeFromTakenOut() {
        return this.takenOut.pop();
    }
}
