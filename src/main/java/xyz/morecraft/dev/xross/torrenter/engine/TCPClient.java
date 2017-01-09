package xyz.morecraft.dev.xross.torrenter.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.morecraft.dev.xross.torrenter.engine.server.cmd.GetDBCommand;
import xyz.morecraft.dev.xross.torrenter.engine.server.cmd.GetDBEntryCommand;
import xyz.morecraft.dev.xross.torrenter.engine.server.cmd.ServerCommand;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TCPClient implements Closeable {

    protected static final Logger log = LoggerFactory.getLogger(TCPClient.class);

    private Socket socket;
    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
    private Queue<ServerCommand> commandsToExecute;

    public TCPClient(String ip, int port) throws IOException {
        this.commandsToExecute = new ConcurrentLinkedQueue<>();

        socket = new Socket(ip, port);

        outToServer = new ObjectOutputStream(socket.getOutputStream());
        inFromServer = new ObjectInputStream(socket.getInputStream());

        new Thread(() -> {
            while (!socket.isClosed() && socket.isConnected()) {
                try {
                    Object o = commandsToExecute.poll();
                    if (o != null) {
                        log.info("Sending object to server: {} of type {}", o, o.getClass());
                        outToServer.writeObject(o);
                        outToServer.flush();
                    }
                    Thread.sleep(1000);
                } catch (IOException | InterruptedException e) {
                    log.error("Error", e);
                    break;
                }
            }
        }).start();

        new Thread(() -> {
            while (!socket.isClosed() && socket.isConnected()) {
                try {
                    Object o = inFromServer.readObject();

                    log.info("Received object from server: {} of type {}", o, o.getClass());

                    Thread.sleep(50);
                } catch (IOException | ClassNotFoundException | InterruptedException e) {
                    log.error("Error", e);
                    break;
                }
            }
        }).start();
    }

    public void executeCommand(ServerCommand serverCommand) {
        commandsToExecute.add(serverCommand);
    }

    public static void main(String[] args) throws IOException {
        TCPClient tcpClient = new TCPClient("localhost", 8888);
        tcpClient.executeCommand(new GetDBCommand());
        tcpClient.executeCommand(new GetDBEntryCommand("023f972d5516ec68aa4a845100555d84"));
        tcpClient.executeCommand(new GetDBEntryCommand("69dec9c2fca3bfdcdc2384c6071b538a"));
        tcpClient.executeCommand(new GetDBEntryCommand("90795e0eef4ae5096c95cd58746590ad"));
        tcpClient.executeCommand(new GetDBEntryCommand("dupa"));
        //tcpClient.close();
    }

    @Override
    public void close() throws IOException {
        socket.close();
    }

}
