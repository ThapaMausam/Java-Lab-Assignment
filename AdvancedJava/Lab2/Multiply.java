package AdvancedJava.Lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Multiply {
    public static void main(String[] args) {

        // Create JFrame
        JFrame frame = new JFrame("Multiplication of two numbers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 10, 10);
        frame.setLayout(layout);

        // Create component
        JLabel num1Label = new JLabel("First Number : ");
        JTextField num1Field = new JTextField(5);

        JLabel num2Label = new JLabel("Second Number: ");
        JTextField num2Field = new JTextField(5);

        JButton mulButton = new JButton("Multiply");

        JLabel resultLabel = new JLabel("Result: ");
        JTextField resultField = new JTextField(5);
        resultField.setEditable(false);

        // Add component to frame
        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(mulButton);
        frame.add(resultLabel);
        frame.add(resultField);

        // Add actionListener
        mulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());

                double mul = num1 * num2;

                resultField.setText(String.valueOf(mul));
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
