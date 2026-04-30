package gui;

import javax.swing.*;
import java.util.Objects;

public class SpriteLoader {

    public ImageIcon loadSprite(String path) {
        return new ImageIcon(getClass().getClassLoader().getResource(path));
    }
}
