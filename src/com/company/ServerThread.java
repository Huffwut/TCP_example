package com.company;

import java.io.*;
import java.net.*;

/**
 * Example taken from https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 *
 * This is a single threaded server, so you need to think of why and how to use multiple threads with this one.
 */
public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            var input = socket.getInputStream();
            var reader = new BufferedReader(new InputStreamReader(input));

            var output = socket.getOutputStream();
            var writer = new PrintWriter(output, true);


            String text;
            do {
                System.out.println("Waiting for client's message: ");
                text = reader.readLine();
                System.out.println("Client's message: " + text);

                System.out.println("Server sent a message back.");
                writer.println("Message received.");

            } while (!text.equals("q"));
            System.out.println("connection closed.");
            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}