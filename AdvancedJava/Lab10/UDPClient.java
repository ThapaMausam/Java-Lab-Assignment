package AdvancedJava.Lab10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    private static final int BUFFER_SIZE = 1024;
    private static DatagramSocket socket;
    private static InetAddress serverAddress;

    public static void main(String[] args) {
        try {
            socket = new DatagramSocket();
            serverAddress = InetAddress.getByName(SERVER_HOST);

            System.out.println("Client started. Connected to server at " + SERVER_HOST + ":" + SERVER_PORT);
            System.out.println("Type messages to send to the server. Type 'bye' to exit.");

            // Start receiver thread
            Thread receiverThread = new Thread(new MessageReceiver());
            receiverThread.start();

            // Start sender thread
            Thread senderThread = new Thread(new MessageSender());
            senderThread.start();

            // Wait for threads to complete
            receiverThread.join();
            senderThread.join();

        } catch (Exception e) {
            System.err.println("Client error: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    // Thread to receive messages from server
    static class MessageReceiver implements Runnable {
        @Override
        public void run() {
            try {
                byte[] buffer = new byte[BUFFER_SIZE];

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                    socket.receive(receivePacket);

                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Server: " + message);

                    if (message.equals("bye")) {
                        System.out.println("Server sent 'bye'. Client closing connection.");
                        System.out.println("Client application ended.");
                        System.exit(0);
                    }
                }
            } catch (IOException e) {
                if (!socket.isClosed()) {
                    System.err.println("Error receiving message: " + e.getMessage());
                }
            }
        }
    }

    // Thread to send messages to server
    static class MessageSender implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            try {
                while (true) {
                    String message = scanner.nextLine();

                    byte[] messageData = message.getBytes();
                    DatagramPacket sendPacket = new DatagramPacket(
                            messageData, messageData.length, serverAddress, SERVER_PORT);

                    socket.send(sendPacket);

                    if (message.equals("bye")) {
                        System.out.println("Client sent 'bye'. Closing connection.");
                        System.out.println("Client application ended.");
                        System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error sending message: " + e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }
}