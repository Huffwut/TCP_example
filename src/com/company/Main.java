package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        var serverSocket = new ServerSocket(6868);


        ServerThread serverThread = new ServerThread(serverSocket.accept());
        serverThread.run();

    }
}
