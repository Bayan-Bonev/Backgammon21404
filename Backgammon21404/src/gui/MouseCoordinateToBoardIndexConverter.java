package gui;

import game_functionalities.GameContext;

import java.awt.*;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.List;

public class MouseCoordinateToBoardIndexConverter {

    BiFunction<Integer, Integer, Point> coordsByIdx =
            (x, y) -> new Point(
                    (x < 6) ? (60 + (x * 50)) : (60 + (x + 1) * 50),
                    (y > 0) ? 700 : 50);

    Point coordsByStackSize(int x, int y, Optional<Integer> stackSize) {
            return new Point(
                    (int) coordsByIdx.apply(x, y).getX(),
                    (int) coordsByIdx.apply(x, y).getY() +
                            (stackSize.isPresent()?
                            GameContext.getBoard().getByIdx(x, y).size() + ((y > 0)? -1 : 1 )* 15:
        stackSize.get()));
    }

    public BoardPosition idxByMouseCoords(int mouseX, int mouseY) {
        Point topLeft;
        Point bottomRight;
        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 12; x++) {
                topLeft = coordsByIdx.apply(x, y);
                bottomRight = coordsByIdx.apply(x + 1, y);

                if (mouseX >= topLeft.x && mouseX < bottomRight.x &&
                        mouseY >= topLeft.y && mouseY < bottomRight.y) {
                    return new BoardPosition(x, y);
                }
            }
        }
        //default
        return null;
    }

    public List<Point> coordsPerStackPosition(int x, int y, Optional<Integer> stackSize) {
        List<Point> coords = new java.util.ArrayList<>();
        for (int i = 0; i < stackSize.get() + 1; i++) {
            coords.add(coordsByStackSize(x, y, stackSize));
        }
        return coords;
    }

    public List<Point> coordsPerStackPosition(BoardPosition p, Optional<Integer> stackSize) {
        List<Point> coords = new java.util.ArrayList<>();
        for (int i = 0; i < stackSize.get() + 1; i++) {
            coords.add(coordsByStackSize(p.getX(), p.getY(), stackSize));
        }
        return coords;
    }
}