package game_functionalities;

import game_objects.GameObjectFactory;
import game_objects.Player;

public class TapaStrategy extends Game implements Strategy {

    public static TapaStrategy INSTANCE;

    private TapaStrategy() {
        super((Player)GameObjectFactory.createInstance("Player"));
    }

    @Override
    public void arrangeBoard() { //todo

    }

    @Override
    public boolean isVulnerable(int x, int y) {
        return this.getBoard().isBlot(x, y) || this.getBoard().isEmpty(x, y);
    }

    @Override
    public int[] getOuterBoardIndices( boolean isWhite) {  // Gets the board quadrant where the player starts.
        return new int[]{
                isWhite? 6 : 11, //upper bound of x
                isWhite? 0 : 1   //y
        };
    }

    @Override
    public int[] getHomeBoardIndices(boolean isWhite) {
        return getOuterBoardIndices( !(isWhite));
    }

    public static TapaStrategy getINSTANCE() {
        return (INSTANCE==null)? new TapaStrategy():INSTANCE;
    }

}
