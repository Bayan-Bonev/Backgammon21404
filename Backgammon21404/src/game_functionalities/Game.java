package game_functionalities;

import game_objects.*;

public abstract class Game {

    private Board board;
    private AbstractPlayer currentPlayer;
    private final Player player;
    private final ArtificialPlayer bot;

    Game() {
        this.setCurrentPlayer(null);
        this.player = null;
        this.bot = null;
        this.setBoard((Board) GameObjectFactory.createInstance("Board"));
    }

    Game(AbstractPlayer currentPlayer) {
        this.setCurrentPlayer(currentPlayer);
        this.player = (currentPlayer instanceof Player)? (Player)currentPlayer: (Player)GameObjectFactory.createInstance("Player");
        this.bot = (currentPlayer instanceof ArtificialPlayer)? (ArtificialPlayer) currentPlayer:new ArtificialPlayer<>();
        this.setBoard((Board) GameObjectFactory.createInstance("Board"));
    }

    abstract boolean canMove();
    abstract boolean isVulnerable(int x, int y);

    abstract void arrangeBoard();
    abstract void movePiece();

    AbstractPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    Player getPlayer() {
        return player;
    }

    ArtificialPlayer getBot() {
        return bot;
    }

    Board getBoard() {
        return board;
    }

    void setCurrentPlayer(AbstractPlayer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
