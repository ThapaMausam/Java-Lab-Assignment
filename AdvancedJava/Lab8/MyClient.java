package AdvancedJava.Lab8;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient {

    private static final String SERVER_IP = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_IP, PORT);
                Scanner clientInputScanner = new Scanner(System.in)) {

            System.out.println("Connected to server: " + SERVER_IP + ":" + PORT);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

                Thread readThread = new Thread(() -> {
                    String serverMessage;
                    try {
                        while ((serverMessage = reader.readLine()) != null) {
                            System.out.println("Server: " + serverMessage);
                            if (serverMessage.equalsIgnoreCase("bye")) {
                                System.out.println("Server sent 'bye'. Client closing connection.");
                                break;
                            }
                        }
                    } catch (IOException e) {
                        System.err.println("Error reading from server: " + e.getMessage());
                    }
                });

                readThread.start();

                String clientMessage;
                System.out.println("Type messages to send to the server. Type 'bye' to exit.");
                while (true) {
                    clientMessage = clientInputScanner.nextLine();
                    writer.println(clientMessage);

                    if (clientMessage.equalsIgnoreCase("bye")) {
                        System.out.println("Client sent 'bye'. Closing connection.");
                        break;
                    }
                }

                readThread.join();

            }
        } catch (UnknownHostException e) {
            System.err.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error connecting to server: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Client thread interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
        System.out.println("Client application ended.");
    }
}