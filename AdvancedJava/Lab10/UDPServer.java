package AdvancedJava.Lab10;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class UDPServer {
    private static final int PORT = 12345;
    private static final int BUFFER_SIZE = 1024;
    private static DatagramSocket socket;
    private static InetAddress clientAddress;
    private static int clientPort;
    private static boolean clientConnected = false;

    public static void main(String[] args) {
        try {
            socket = new DatagramSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT + "...");

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
            System.err.println("Server error: " + e.getMessage());
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }

    // Thread to receive messages from client
    static class MessageReceiver implements Runnable {
        @Override
        public void run() {
            try {
                byte[] buffer = new byte[BUFFER_SIZE];

                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                    socket.receive(receivePacket);

                    // Store client details for response
                    clientAddress = receivePacket.getAddress();
                    clientPort = receivePacket.getPort();

                    if (!clientConnected) {
                        System.out.println("Client connected: " + clientAddress.getHostAddress());
                        System.out.println("Type messages to send to the client. Type 'bye' to exit.");
                        clientConnected = true;
                    }

                    String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("Client: " + message);

                    if (message.equals("bye")) {
                        System.out.println("Client sent 'bye'. Server closing connection.");
                        System.out.println("Server application ended.");
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

    // Thread to send messages to client
    static class MessageSender implements Runnable {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);

            try {
                while (true) {
                    if (clientConnected) {
                        String message = scanner.nextLine();

                        byte[] messageData = message.getBytes();
                        DatagramPacket sendPacket = new DatagramPacket(
                                messageData, messageData.length, clientAddress, clientPort);

                        socket.send(sendPacket);

                        if (message.equals("bye")) {
                            System.out.println("Server sent 'bye'. Closing connection.");
                            System.out.println("Server application ended.");
                            System.exit(0);
                        }
                    } else {
                        // Wait a bit before checking again
                        Thread.sleep(100);
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