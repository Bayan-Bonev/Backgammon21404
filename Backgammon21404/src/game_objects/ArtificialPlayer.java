package game_objects;

import game_functionalities.Game;
import game_functionalities.State;
import utilities.board_logic_utilities.MoveEvaluator;
import utilities.board_logic_utilities.MoveSimulator;
import utilities.board_logic_utilities.MoveValidator;

import java.util.function.Supplier;

public class ArtificialPlayer<T extends State> extends AbstractPlayer {

    private T currentState;
    public static MoveValidator<T> validator = new MoveValidator(new Supplier<T>().get());
    public static MoveEvaluator<T> evaluator = new MoveEvaluator(new Supplier<T>().get());
    public static MoveSimulator

    ArtificialPlayer() {
        super();
    }

    T getState() {
        return this.currentState;
    }
    
}
