import game_functionalities.GameContext;
import game_functionalities.State;
import game_objects.AbstractPlayer;
import game_objects.ArtificialPlayer;
import game_objects.Player;
import utilities.Input;
import utilities.exceptions.InvalidInputException;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class GameController {

    private State currentState;

    public GameController() {
        try {
            this.currentState = Input.readState();
        } catch (InvalidInputException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        while(!isOver()) {
            turn();
        }
    }

    public void turn() {
        AbstractPlayer currentPlayer = GameContext.getCurrentPlayer();
        currentPlayer.rollDice();
        int[] dice = currentPlayer.getDice();
        int turnsLeft = currentPlayer.getDice().length;

        while (turnsLeft > 0) {
            try {
                if (currentPlayer instanceof Player) {
                    GameContext.movePiece(Input.readMove());
                }
                else {
                    GameContext.getBot().play();
                }
                turnsLeft -= 1;
            } catch (InvalidInputException e) {
                throw new RuntimeException(e);
            }
        }
    }

    boolean isOver() {
        return GameContext.getCurrentPlayer().getTakenOut().size() == 15;
    }

}