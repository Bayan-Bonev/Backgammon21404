package game_objects;

import game_functionalities.State;
import utilities.board_logic_utilities.MoveAgentFactory;
import utilities.board_logic_utilities.MoveEvaluator;
import utilities.board_logic_utilities.MoveSimulator;
import utilities.board_logic_utilities.MoveValidator;

public class ArtificialPlayer extends AbstractPlayer {

    private State currentState;
    public static MoveValidator validator = (MoveValidator) MoveAgentFactory.createInstance("validator");
    public static MoveEvaluator evaluator = (MoveEvaluator) MoveAgentFactory.createInstance("evaluator");
    public static MoveSimulator simulator = (MoveSimulator) MoveAgentFactory.createInstance("simulator");

    ArtificialPlayer() {
        super();
    }

    ArtificialPlayer(State state) {
        validator.setState(state);
        evaluator.setState(state);
        simulator.setState(state);
    }

    void play() {

    }

    public void setState(State state) {
        this.currentState = state;
    }
    
}
