package gui;

import javax.swing.*;
import java.awt.*;

public class Setup {

    static final GameFrame w = new GameFrame();
    static final int FPS = 60;


    public void setupGUI() {
        w.setSize(new Dimension(GameFrame.WIDTH, GameFrame.HEIGHT));
        w.setLocationRelativeTo(null);
        w.setResizable(false);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
