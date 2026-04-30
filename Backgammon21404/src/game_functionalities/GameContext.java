package game_functionalities;

import game_objects.*;
import utilities.board_logic_utilities.Move;

public class GameContext {

    public static Game gameInstance;
    public static GameStrategy currentState;

    public GameContext(GameStrategy currentState) {
        gameInstance = (Game)currentState;
        currentState = currentState;
    }

    public GameStrategy getCurrentState() {
        if (currentState instanceof TablaStrategy) {
            return TablaStrategy.getINSTANCE();
        }
        else if(currentState instanceof GiulbaraStrategy) {
            return GiulbaraStrategy.getINSTANCE();
        }
        else {
            return TapaStrategy.getINSTANCE();
        }
    }

    public static void movePiece(Move move) {gameInstance.movePiece(move);
    }

    public boolean canMove() {
        return (GameContext.getCurrentPlayer().capturedIsEmpty());
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
    public static void setCurrentPlayer(AbstractPlayer currentPlayer) {
        gameInstance.setCurrentPlayer(currentPlayer);
    }

    public static Player getPlayer() {
        return gameInstance.getPlayer();
    }
    public static void setPlayer(Player player) {
        gameInstance.setPlayer(player);
    }

    public static ArtificialPlayer getBot() {
        return gameInstance.getBot();
    }
    public static void setBot(ArtificialPlayer bot) {
        gameInstance.setBot(bot);
    }

    public static GameStrategy getState() {
        return currentState;
    }
}