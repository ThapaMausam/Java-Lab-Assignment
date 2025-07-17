package AdvancedJava.Lab5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Notepad");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create textArea
        JTextArea textArea = new JTextArea();

        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Always show vertical scrollbar
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Always hide horizontal

        // Create JPanel
        JPanel buttonPanel = new JPanel();

        // Create JButton
        JButton newButton = new JButton("New");
        JButton openButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");

        // Create filechooser
        JFileChooser fileChooser = new JFileChooser();

        // Add ActionListener to buttons
        // newButton
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                JOptionPane.showMessageDialog(frame, "New document created", "New", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // openButton
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = fileChooser.showOpenDialog(frame);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File currentFile = fileChooser.getSelectedFile();
                    try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                        StringBuilder sb = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line).append("\n");
                        }
                        textArea.setText(sb.toString());
                        JOptionPane.showMessageDialog(frame, "File opened successfully", "Open Status",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error opening file: " + ex.getMessage(), "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        });

        // saveButton
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = fileChooser.showSaveDialog(frame);

                if (choice == JFileChooser.APPROVE_OPTION) {
                    File currentFile = fileChooser.getSelectedFile();

                    try (PrintWriter writer = new PrintWriter(new FileWriter(currentFile))) {
                        writer.println(textArea.getText());
                        JOptionPane.showMessageDialog(frame, "File saved successfully", "Save Status",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "Error saving file", ex.getMessage(),
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // exit Button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Add Jbutton to Jpanel
        buttonPanel.add(newButton);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(exitButton);

        // Add scollPane ti Jframe
        frame.add(scrollPane, BorderLayout.CENTER);

        // buttonpanel to frame
        frame.add(buttonPanel, BorderLayout.NORTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
