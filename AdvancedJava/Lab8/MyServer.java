package AdvancedJava.Lab8;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyServer {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
                Scanner serverInputScanner = new Scanner(System.in)) {

            System.out.println("Server started. Listening on port " + PORT + "...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()),
                                true)) {

                    Thread readThread = new Thread(() -> {
                        String clientMessage;
                        try {
                            while ((clientMessage = reader.readLine()) != null) {
                                System.out.println("Client: " + clientMessage);
                                if (clientMessage.equalsIgnoreCase("bye")) {
                                    System.out.println("Client sent 'bye'. Server closing connection.");
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            System.err.println("Error reading from client: " + e.getMessage());
                        }
                    });

                    readThread.start();

                    String serverMessage;
                    System.out.println("Type messages to send to the client. Type 'bye' to exit.");
                    while (true) {
                        serverMessage = serverInputScanner.nextLine();
                        writer.println(serverMessage);

                        if (serverMessage.equalsIgnoreCase("bye")) {
                            System.out.println("Server sent 'bye'. Closing connection.");
                            break;
                        }
                    }

                    readThread.join();

                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Server thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println("Server application ended.");
    }
}