package game_functionalities;

import game_objects.AbstractPlayer;
import game_objects.Player;
import utilities.board_logic_utilities.Move;
import java.util.Random;

public class TurnEngine {

    private static final java.util.Random random = new java.util.Random();

    public static Move currentMove;
    public static int[] dice;


    public TurnEngine() {
         currentMove = null;
    }

    public static void rollDice() {
        int d1 = random.nextInt(1, 6);
        int d2 = random.nextInt(1, 6);
        dice = ((d1==d2)? new int[]{d1, d2} : new int[]{d1,d1,d2,d2});
    }

    public void turn() {
        AbstractPlayer currentPlayer = GameContext.getCurrentPlayer();
        rollDice();
        int turnsLeft = dice.length;

        while (turnsLeft > 0) {
            try {
                if (currentPlayer instanceof Player && currentPlayer != null) {
                    GameContext.movePiece(currentMove);
                }
                else {
                    GameContext.getBot().play();
                }
                turnsLeft -= 1;
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        GameContext.gameInstance.switchPlayer();
    }

    private void waitForUserMove(Move m) {
        synchronized (this) {
            try {
                while (currentMove == null) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isOver() {
        return GameContext.getCurrentPlayer().getTakenOut().size() == 15;
    }

}