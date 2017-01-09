package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TCP {
    //tracker port 5555

    public void TCPServer(int trackerPort) throws IOException {

        ServerSocket serverSocket = new ServerSocket(0);

        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        }
    }

    public void TCPClient(int localPort, String filename, String command) {
        SimpleFileDB simpleFileDB = new SimpleFileDB();

        }


    }
}

