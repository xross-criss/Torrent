package xyz.morecraft.dev.xross.torrenter.engine.server.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.morecraft.dev.xross.torrenter.engine.server.Server;

import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class ServerCommand implements Serializable {

    protected static final Logger log = LoggerFactory.getLogger(ServerCommand.class);

    public abstract void run(Server server, ObjectOutputStream outputStream);

}
