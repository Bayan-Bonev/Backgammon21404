package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import game_functionalities.TurnEngine;
import utilities.board_logic_utilities.Move;

public class InputListener {

    private static final MouseCoordinateToBoardIndexConverter CONVERTER = new MouseCoordinateToBoardIndexConverter();
    private final GamePanel gamePanel;
    private int initialX, initialY;
    private int currentX, currentY;

    public InputListener(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        // Add mouse listeners to the GamePanel
        gamePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseReleased(e);
            }
        });

        gamePanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseDragged(e);
            }
        });
    }

    private void handleMousePressed(MouseEvent e) {
        // Initialize the starting position
        initialX = e.getX();
        initialY = e.getY();
    }

    private void handleMouseDragged(MouseEvent e) {

        currentX = e.getX();
        currentY = e.getY();
        gamePanel.repaint();
    }

    private void handleMouseReleased(MouseEvent e) {
        // Finalize the move
        currentX = e.getX();
        currentY = e.getY();
        buildMove(initialX, initialY, currentX, currentY);

    }

    private void buildMove(int startX, int startY, int endX, int endY) {
        // Convert pixel coordinates to board indices
        BoardPosition start = CONVERTER.idxByMouseCoords(startX, startY);
        BoardPosition end = CONVERTER.idxByMouseCoords(endX, endY);

        // Create and return a Move object
        TurnEngine.currentMove = new Move(start.getX(), start.getY(), end.getX(), end.getY());
    }
}