package AdvancedJava.Lab9;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String SERVER_HOST = "localhost";
        final int SERVER_PORT = 8080;

        Scanner scanner = new Scanner(System.in);

        try {
            // Connect to server
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Connected to Circle Area Server");

            // Create input and output streams
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Get radius from user
            System.out.print("Enter the radius of the circle: ");
            String radius = scanner.nextLine();

            // Send radius to server
            out.println(radius);
            System.out.println("Sent radius to server: " + radius);

            // Receive area from server
            String response = in.readLine();

            if (response.startsWith("ERROR:")) {
                System.out.println("Server error: " + response);
            } else {
                double area = Double.parseDouble(response);
                System.out.println("\n--- Result ---");
                System.out.println("Radius: " + radius);
                System.out.printf("Area of circle: %.2f%n", area);
                System.out.printf("Area of circle: %.6f%n", area);
            }

            // Close connection
            socket.close();
            System.out.println("\nConnection closed");

        } catch (UnknownHostException e) {
            System.err.println("Cannot connect to server: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Invalid response from server: " + e.getMessage());
        }

        scanner.close();
    }
}
