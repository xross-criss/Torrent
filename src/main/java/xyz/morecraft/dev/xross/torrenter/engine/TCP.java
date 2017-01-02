package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TCP {
    //tracker port 5555

    public static void TCPServer(int trackerPort) throws IOException {

        ServerSocket serverSocket = new ServerSocket(0);

        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            String[] parts = inputLine.split("\\s");
            String command = parts[0];
            String filename = parts[1];

            if (command == "PUSH" || inputLine == "PULL") {
                TCPClient(serverSocket.getLocalPort(), filename, command);
            }
        }
    }

    public static void TCPClient(int localPort, String filename, String command) {
        SimpleFileDB simpleFileDB = new SimpleFileDB();


        if (command == "PUSH") {
            if (!simpleFileDB.contains(filename)) {

            } else {

            }
        }


    }
}

