package game_objects;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameObjectFactory {

    private static final Map<String, Supplier<IGameObject>> constructors = Map.of(
            "Board", Board::new,
            "Player",Player::new,
            "Artificial player", ArtificialPlayer::new
    );

    public static IGameObject createInstance(String objType) {
        return constructors.get(objType).get();
    }

}
