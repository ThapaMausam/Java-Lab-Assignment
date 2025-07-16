package AdvancedJava.Lab4;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.*;

public class Authenticate {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 130);
        frame.setLayout(new BorderLayout(5, 5));

        // Create Panel
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
        JPanel printPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));

        // Create component
        JLabel nameLabel = new JLabel("Username: ");
        JTextField nameField = new JTextField("Mausam Thapa", 10);

        JLabel passwordLabel = new JLabel("Password: ");
        JTextField passwordField = new JTextField("Password", 10);

        JButton loginButton = new JButton("Login");

        JLabel resultLabel = new JLabel("");

        // Add component to panel
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        buttonPanel.add(loginButton);

        printPanel.add(resultLabel);

        // Add panel to frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(printPanel, BorderLayout.SOUTH);

        // Action Handle
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = nameField.getText();
                String password = passwordField.getText();
                final String check = "admin";

                if (username.equals(check) && password.equals(check)) {
                    resultLabel.setText("Access Granted");
                } else {
                    resultLabel.setText("Access Denied");
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}