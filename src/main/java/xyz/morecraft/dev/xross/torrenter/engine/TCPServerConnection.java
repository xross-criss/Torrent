package xyz.morecraft.dev.xross.torrenter.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.morecraft.dev.xross.torrenter.engine.server.Server;
import xyz.morecraft.dev.xross.torrenter.engine.server.cmd.ServerCommand;
import xyz.morecraft.dev.xross.torrenter.engine.server.dto.CommunicationException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPServerConnection implements Runnable {

    protected static final Logger log = LoggerFactory.getLogger(TCPServerConnection.class);

    private Server server;
    private Socket clientSocket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;

    public TCPServerConnection(Socket clientSocket, Server server) throws IOException {
        this.server = server;
        this.clientSocket = clientSocket;
        outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
        inFromClient = new ObjectInputStream(clientSocket.getInputStream());
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object o = inFromClient.readObject();

                log.info("Received object from client [{}]: {} of type {}", clientSocket.getInetAddress().getHostAddress(), o, o.getClass());

                if (o instanceof ServerCommand) {
                    ((ServerCommand) o).run(server, outToClient);
                    outToClient.flush();
                } else {
                    log.error("Unknown object received from: {}", clientSocket.getInetAddress().getHostAddress());
                    outToClient.writeObject(new CommunicationException("Unknown object"));
                }

                Thread.sleep(50);
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                if (!clientSocket.isConnected()) {
                    try {
                        clientSocket.close();
                    } catch (IOException e1) {
                        log.error("Error while closing socket", e1);
                    }
                    log.error("Connection with {} is closed", clientSocket.getInetAddress().getHostAddress());
                } else {
                    log.error("Error", e);
                }
                break;
            }
        }
    }

}
