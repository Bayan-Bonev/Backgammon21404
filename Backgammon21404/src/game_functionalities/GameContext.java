package game_functionalities;

import game_objects.*;

public class GameContext {

    private static Game gameInstance;
    private static State currentState;

    GameContext(State currentState) {
        this.currentState = currentState;
    }

    public static void start() {

    }

    public State getCurrentState() {
        if (currentState instanceof BackgammonState) {
            return BackgammonState.getINSTANCE();
        }
        else if(currentState instanceof GiulbaraState) {
            return GiulbaraState.getINSTANCE();
        }
        else {
            return TapaState.getINSTANCE();
        }
    }

    public static Board getBoard() {
        return gameInstance.getBoard();
    }

    public static void setBoard(Board board) {
        gameInstance.setBoard(board);
    }

    public static AbstractPlayer getCurrentPlayer() {
        return gameInstance.getCurrentPlayer();
    }

    public static Player getPlayer() {
        return gameInstance.getPlayer();
    }

    public static ArtificialPlayer getBot() {
        return gameInstance.getBot();
    }

    public static State getState() {
        return currentState;
    }

}