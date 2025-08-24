package AdvancedJava.Lab9;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 8080;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Circle Area Server started on port " + PORT);
            System.out.println("Waiting for client connection...");

            while (true) {
                // Accept client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(
                        clientSocket.getOutputStream(), true);

                try {
                    // Read radius from client
                    String radiusStr = in.readLine();
                    System.out.println("Received radius: " + radiusStr);

                    // Parse radius and calculate area
                    double radius = Double.parseDouble(radiusStr);
                    double area = Math.PI * radius * radius;

                    System.out.println("Calculated area: " + area);

                    // Send area back to client
                    out.println(area);

                } catch (NumberFormatException e) {
                    System.err.println("Invalid radius received: " + e.getMessage());
                    out.println("ERROR: Invalid radius format");
                } catch (IOException e) {
                    System.err.println("Error communicating with client: " + e.getMessage());
                }

                // Close client connection
                clientSocket.close();
                System.out.println("Client disconnected\n");
            }

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
