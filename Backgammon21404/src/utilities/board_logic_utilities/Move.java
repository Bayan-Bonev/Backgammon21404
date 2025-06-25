package utilities.board_logic_utilities;

import game_functionalities.*;

import java.util.List;

public class Move {

    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double riskRewardRatio;
    private List<Move> possibleMoves;

    Move(int x1, int y1, int dieValue) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = determineIndicesAfterMove(x1, y1, dieValue)[0];
        this.x2 = determineIndicesAfterMove(x1, y1, dieValue)[0];
    }

    Move(int x1, int y1, int x2, int y2) {
        this.setX1(x1);
        this.setY1(y1);
        this.setX2(x2);
        this.setY2(y2);
    }

    public int[] determineIndicesAfterMove(int x, int y,int dieValue) {
        int colourFactor = (GameContext.getCurrentPlayer().isWhite())? -1: 1;
        int directionMod = (y == 0)? 1: -1;

        x = x + dieValue*(colourFactor*directionMod);

        if (x > 12 && y == 0) {
            y++;
        }
        else if (x < 0 && y == 1) {
            y--;
        }
        return new int[]{x, y};
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public double getRiskRewardRatio() {
        return riskRewardRatio;
    }

    public void setRiskRewardRatio(double riskRewardRatio) {
        this.riskRewardRatio = riskRewardRatio;
    }

    public List<Move> getPossibleMoves() {
        return possibleMoves;
    }

    public void setPossibleMoves(List<Move> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }
}