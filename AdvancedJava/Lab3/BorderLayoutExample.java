package AdvancedJava.Lab3;

import java.awt.*;
import javax.swing.*;

public class BorderLayoutExample {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("BorderLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Create components
        JButton button1 = new JButton("NORTH");
        JButton button2 = new JButton("WEST");
        JButton button3 = new JButton("CENTER");
        JButton button4 = new JButton("EAST");
        JButton button5 = new JButton("SOUTH");

        // Add component
        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.WEST);
        frame.add(button4, BorderLayout.EAST);
        frame.add(button5, BorderLayout.SOUTH);
        frame.add(button3, BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
