package gui;

import game_objects.Board;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

public class GamePanel extends JPanel {

    private static final SpriteLoader SP = new SpriteLoader();
    private static final MouseCoordinateToBoardIndexConverter CONVERTER = new MouseCoordinateToBoardIndexConverter();
    private final ImageIcon boardSprite = SP.loadSprite("backgammon_board.png");

    private final ImageIcon W_SPRITE = SP.loadSprite("pieces/white.png");
    private final ImageIcon B_SPRITE = SP.loadSprite("pieces/red.png");
    private final ImageIcon W_INVERTED = SP.loadSprite("pieces/white_inverted.png");
    private final ImageIcon B_INVERTED = SP.loadSprite("pieces/red_inverted.png");

    private Map<ImageIcon, Predicate<Integer>> spriteConditions = Map.of(
            W_SPRITE, (y) -> y == 50,
            B_SPRITE, (y) -> y == 50,
            W_INVERTED, (y) -> y == 700,
            B_INVERTED, (y) -> y == 700
    );

    private Map<ImageIcon, List<Point>> spriteCoords;

    public GamePanel() {
        initializeBoardState();
    }

    private void initializeBoardState() {
        updateSpriteCoords();
    }

    private void updateSpriteCoords() {
        spriteCoords = Map.of(
                W_SPRITE, coordinatesPerSprite(true)
                        .stream()
                        .filter(p -> spriteConditions.get(W_SPRITE).test((int) p.getY()))
                        .toList(),
                B_SPRITE, coordinatesPerSprite(false)
                        .stream()
                        .filter(p -> spriteConditions.get(B_SPRITE).test((int) p.getY()))
                        .toList(),
                W_INVERTED, coordinatesPerSprite(true)
                        .stream()
                        .filter(p -> spriteConditions.get(W_INVERTED).test((int) p.getY()))
                        .toList(),
                B_INVERTED, coordinatesPerSprite(false)
                        .stream()
                        .filter(p -> spriteConditions.get(B_INVERTED).test((int) p.getY()))
                        .toList()
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the board
        g.drawImage(boardSprite.getImage(), 0, 0, getWidth(), getHeight(), this);

        // Draw the pieces
        paintPieces(g);
    }

    private void paintPieces(Graphics g) {
        for (Map.Entry<ImageIcon, List<Point>> entry : spriteCoords.entrySet()) {
            ImageIcon sprite = entry.getKey();
            for (Point p : entry.getValue()) {
                g.drawImage(sprite.getImage(), (int) p.getX(), (int) p.getY(), this);
            }
        }
    }

    private List<Point> coordinatesPerSprite(boolean isWhite) {
        List<BoardPosition> spritePositions =
                Board.getStackSizeMap(isWhite).entrySet().stream()
                        .filter(entry -> entry.getValue() > 0)
                        .map(Map.Entry::getKey)
                        .toList();

        return spritePositions.stream()
                .flatMap(pos -> CONVERTER.coordsPerStackPosition(pos, Optional.empty()).stream())
                .toList();
    }
}