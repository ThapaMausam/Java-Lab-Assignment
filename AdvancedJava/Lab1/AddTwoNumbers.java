package AdvancedJava.Lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTwoNumbers {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Add Two Numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Create components
        JLabel num1Label = new JLabel("First Number:");
        JTextField num1Field = new JTextField(10);

        JLabel num2Label = new JLabel("Second Number:");
        JTextField num2Field = new JTextField(10);

        JButton addButton = new JButton("Add");
        JLabel resultLabel = new JLabel("Result:");
        JTextField resultField = new JTextField(10);
        resultField.setEditable(false);

        // Add components to frame
        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(resultLabel);
        frame.add(resultField);

        // Add action listener
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double sum = num1 + num2;
                resultField.setText(String.valueOf(sum));
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}