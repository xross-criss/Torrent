package xyz.morecraft.dev.xross.torrenter.engine.client;

import xyz.morecraft.dev.xross.torrenter.engine.TCPClient;

public class Client {

    private final TCPClient tcpClient;

    public Client(TCPClient tcpClient) {
        this.tcpClient = tcpClient;
    }

    public TCPClient getTcpClient() {
        return tcpClient;
    }

}
