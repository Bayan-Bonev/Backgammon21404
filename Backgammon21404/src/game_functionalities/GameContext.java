package game_functionalities;

public class GameContext<T extends State> {

    private T currentState;

    GameContext(T currentState) {
        this.currentState = currentState;
    }

}
