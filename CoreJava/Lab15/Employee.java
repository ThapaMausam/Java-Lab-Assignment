package CoreJava.Lab15;

import java.io.PrintWriter;
import java.io.FileWriter;
// import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "/Users/mausamthapa/Java-Lab-Assignment/Corejava/Lab15/Emp.txt";

        System.out.println("--- Enter Employee Details ---");
        System.out.print("Enter employee id: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter employee name: ");
        String name = input.nextLine();

        System.out.print("Enter employee address: ");
        String address = input.nextLine();

        System.out.print("Enter employee DOB (YYYY-MM-DD): ");
        String dob = input.nextLine();

        System.out.print("Enter employee phone number: ");
        String phNum = input.nextLine();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println("ID: " + id);
            writer.println("Name: " + name);
            writer.println("Address: " + address);
            writer.println("DOB: " + dob);
            writer.println("Phone: " + phNum);
            writer.println("\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        /*
         * try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,
         * true))) { // true for append mode
         * writer.write("ID: " + id);
         * writer.newLine(); // Use newLine() for platform-independent line breaks
         * writer.write("Name: " + name);
         * writer.newLine();
         * writer.write("Address: " + address);
         * writer.newLine();
         * writer.write("DOB: " + dob);
         * writer.newLine();
         * writer.write("Phone: " + phoneNumber);
         * writer.newLine();
         * writer.write("--------------------");
         * writer.newLine();
         * 
         * System.out.println("\nEmployee data successfully saved to " + fileName);
         * 
         * } catch (IOException e) {
         * System.err.println("Error writing to file: " + e.getMessage());
         * }
         */

        BufferedReader reader = null;
        System.out.println("\n--- Employee Contents ---");
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing reader: " + e.getMessage());
                }
            }
            input.close();
        }
    }
}
