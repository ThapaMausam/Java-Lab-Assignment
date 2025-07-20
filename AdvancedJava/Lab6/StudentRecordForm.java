package AdvancedJava.Lab6;

import java.awt.*;
import javax.swing.*;

public class StudentRecordForm {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create frame
            JFrame frame = new JFrame("Asian College Student Form");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create panel with border (outer padding)
            JPanel panel = new JPanel(new GridBagLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // 20px margin around form

            // Create GridBagConstraints
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 10, 5); // Default row spacing: 10px bottom

            // Title
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(0, 0, 20, 0); // Extra space below title
            JLabel title = new JLabel("Student Form");
            title.setFont(new Font("SansSerif", Font.BOLD, 20));
            panel.add(title, gbc);

            // Reset default insets for the rest
            gbc.insets = new Insets(5, 5, 10, 5);

            // First Name
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("First Name:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.EAST;
            JTextField firstNameField = new JTextField(20);
            panel.add(firstNameField, gbc);

            // Last Name
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Last Name:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.EAST;
            JTextField lastNameField = new JTextField(20);
            panel.add(lastNameField, gbc);

            // Age
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Age:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.EAST;
            JTextField ageField = new JTextField(20);
            panel.add(ageField, gbc);

            // Gender Label
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Gender:"), gbc);

            // Gender Radio Buttons
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0)); // 10px gap between buttons
            JRadioButton maleRadio = new JRadioButton("Male");
            JRadioButton femaleRadio = new JRadioButton("Female");
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(maleRadio);
            genderGroup.add(femaleRadio);
            radioPanel.add(maleRadio);
            radioPanel.add(femaleRadio);
            panel.add(radioPanel, gbc);

            // Faculty
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Faculty:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.EAST;
            String[] faculties = { "Select Faculty", "BIM", "BCA", "CSIT", "BBM" };
            JComboBox<String> facultyCombo = new JComboBox<>(faculties);
            panel.add(facultyCombo, gbc);

            // Semester
            gbc.gridx = 0;
            gbc.gridy = 6;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Semester:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 6;
            gbc.gridwidth = 2;
            gbc.anchor = GridBagConstraints.EAST;
            String[] semesters = { "Select Semester", "1st Semester", "2nd Semester", "3rd Semester", "4th Semester",
                    "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
            JComboBox<String> semesterCombo = new JComboBox<>(semesters);
            panel.add(semesterCombo, gbc);

            // Remarks Label
            gbc.gridx = 0;
            gbc.gridy = 7;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.WEST;
            panel.add(new JLabel("Remarks:"), gbc);

            // Remarks Text Area (larger and resizable)
            gbc.gridx = 1;
            gbc.gridy = 7;
            gbc.gridwidth = 2;
            gbc.gridheight = 3;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.fill = GridBagConstraints.BOTH; // Allow it to expand
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.insets = new Insets(5, 5, 15, 5); // Extra bottom padding
            JTextArea remarkArea = new JTextArea(5, 20); // Default 5 rows tall
            JScrollPane remarkScroll = new JScrollPane(remarkArea);
            panel.add(remarkScroll, gbc);

            // Submit Button with extra spacing above
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
            gbc.gridx = 0;
            gbc.gridy = 10;
            gbc.gridwidth = 3;
            gbc.gridheight = 1;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.insets = new Insets(20, 5, 5, 5); // 20px space above the button
            gbc.fill = GridBagConstraints.NONE;
            gbc.weightx = 0;
            gbc.weighty = 0;
            buttonPanel.add(new JButton("Submit"));
            panel.add(buttonPanel, gbc);

            // Add panel to frame
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
