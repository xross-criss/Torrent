package xyz.morecraft.dev.xross.torrenter.engine.server;

import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

public class Server {

    private final FileDB fileDB;

    public Server(FileDB fileDB) {
        this.fileDB = fileDB;
    }

    public FileDB getFileDB() {
        return fileDB;
    }

}
