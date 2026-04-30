package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {

    public static String selectedDifficulty;
    public static String selectedColor;
    public static String selectedGame;

    public StartMenu() {
        setTitle("Start Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Difficulty selection
        JLabel difficultyLabel = new JLabel("Select Bot Difficulty:");
        String[] difficulties = {"Easy", "Medium", "Hard"};
        JComboBox<String> difficultyComboBox = new JComboBox<>(difficulties);

        // Color selection
        JLabel colorLabel = new JLabel("Select Your Piece Color:");
        String[] colors = {"White", "Black"};
        JComboBox<String> colorComboBox = new JComboBox<>(colors);

        // Game selection
        JLabel gameLabel = new JLabel("Select Game:");
        String[] games = {"Табла", "Гюлбара", "Тапа"};
        JComboBox<String> gameComboBox = new JComboBox<>(games);

        // Confirm button
        JButton confirmButton = new JButton("Start Game");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSelectedDifficulty((String) difficultyComboBox.getSelectedItem());
                setSelectedColor((String) colorComboBox.getSelectedItem());
                setSelectedGame((String) gameComboBox.getSelectedItem());

                // Close the menu and proceed to the game
                dispose();
            }
        });

        // Add components to the frame
        add(difficultyLabel);
        add(difficultyComboBox);
        add(colorLabel);
        add(colorComboBox);
        add(gameLabel);
        add(gameComboBox);
        add(new JLabel());
        add(confirmButton);

        setVisible(true);
    }

    public String getSelectedDifficulty() {
        return selectedDifficulty;
    }

    public void setSelectedDifficulty(String selectedDifficulty) {
        this.selectedDifficulty = selectedDifficulty;
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor;
    }

    public String getSelectedGame() {
        return selectedGame;
    }

    public void setSelectedGame(String selectedGame) {
        this.selectedGame = selectedGame;
    }
}