package CoreJava.Lab16;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

public class Student {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName1 = "/Users/mausamthapa/Java-Lab-Assignment/CoreJava/Lab16/std.txt";
        String fileName2 = "/Users/mausamthapa/Java-Lab-Assignment/CoreJava/Lab16/std1.txt";

        System.out.println("--- Enter Student Details ---");
        System.out.print("Enter student name: ");
        String name = input.nextLine();

        System.out.print("Enter student age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.print("Enter student grade: ");
        String grade = input.nextLine();

        System.out.print("Enter student contact: ");
        String contact = input.nextLine();

        // Writing to std.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1))) {
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Age: " + age);
            writer.newLine();
            writer.write("Grade: " + grade);
            writer.newLine();
            writer.write("Contact Number: " + contact);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error writing to file:" + e.getMessage());
        }

        // Copying from std.txt to std1.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
                PrintWriter writer1 = new PrintWriter(new FileWriter(fileName2))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer1.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error copying to file:" + e.getMessage());
        } finally {
            input.close();
        }

        // Displaying std1.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName2));) {
            String line;
            System.out.println("\n--- Student Details ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading to file:" + e.getMessage());
        }
    }
}