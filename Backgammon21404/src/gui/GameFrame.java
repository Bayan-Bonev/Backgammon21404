package gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class GameFrame extends JFrame {

    static final int HEIGHT = 760;
    static final int WIDTH = 760;

    static final ImageIcon BOARD_SPRITE = new ImageIcon("Backgammon21404/sprites/backgammon_board.png");
    static final HashMap<Integer, ImageIcon> DICE_SPRITES_FACE = (HashMap<Integer, ImageIcon>) Map.of(
            1, new ImageIcon("sprites/dice/dice_face1"),
            2, new ImageIcon("sprites/dice/dice_face1"),
            3, new ImageIcon("sprites/dice/dice_face1"),
            4, new ImageIcon("sprites/dice/dice_face1"),
            5, new ImageIcon("sprites/dice/dice_face1"),
            6, new ImageIcon("sprites/dice/dice_face1")
    );

    static final HashMap<Integer, ImageIcon> DICE_SPRITES_SIDE = (HashMap<Integer, ImageIcon>) Map.of(
            1, new ImageIcon("sprites/dice/dice_side1"),
            2, new ImageIcon("sprites/dice/dice_side2"),
            3, new ImageIcon("sprites/dice/dice_side3"),
            4, new ImageIcon("sprites/dice/dice_side4"),
            5, new ImageIcon("sprites/dice/dice_side5"),
            6, new ImageIcon("sprites/dice/dice_side6")
    );

    static final HashMap<Integer, Point> PIECE_COORDINATES = (HashMap<Integer, Point>) Map.of(
            1, new Point(1, 1),
            1, new Point()
    );

    public GameFrame(){
        this.add(new JLabel(BOARD_SPRITE));

    };
    
}
