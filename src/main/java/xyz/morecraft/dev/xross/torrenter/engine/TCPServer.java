package xyz.morecraft.dev.xross.torrenter.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;
import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;
import xyz.morecraft.dev.xross.torrenter.engine.server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    protected static final Logger log = LoggerFactory.getLogger(TCPServer.class);

    private Server server;
    private ServerSocket serverSocket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public TCPServer(int port, Server server) throws IOException {
        this.server = server;
        serverSocket = new ServerSocket(port);
    }

    public void mainLoop() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            log.info("Received new connection from: {}", socket.getInetAddress().getHostAddress());
            new Thread(new TCPServerConnection(socket, server)).start();
        }
    }

    public static void main(String[] args) throws IOException {
        FileDB fileDB = new SimpleFileDB();
        FileProcessor fileProcessor = new FileProcessor(fileDB);
        fileProcessor.loadAllFilesFromFolder("E:\\programowanie\\workspace\\Torrenter");
        log.info("Initialized DB with {} entries", fileDB.size());

        /*
         * 023f972d5516ec68aa4a845100555d84
         * 90795e0eef4ae5096c95cd58746590ad
         * 69dec9c2fca3bfdcdc2384c6071b538a
         */

        Server server = new Server(fileDB);

        new TCPServer(8888, server).mainLoop();
    }

}
