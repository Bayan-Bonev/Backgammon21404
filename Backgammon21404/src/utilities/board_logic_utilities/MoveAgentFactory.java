package utilities.board_logic_utilities;

import game_objects.ArtificialPlayer;
import game_objects.Board;
import game_objects.IGameObject;
import game_objects.Player;

import java.util.Map;
import java.util.function.Supplier;

public class MoveAgentFactory {

    private static final Map<String, Supplier<MoveAgent>> constructors = Map.of(
            "validator", MoveValidator::new,
            "evaluator", MoveEvaluator::new,
            "simulator", MoveSimulator::new
    );

    public static MoveAgent createInstance(String objType) {
        return constructors.get(objType).get();
    }

}
