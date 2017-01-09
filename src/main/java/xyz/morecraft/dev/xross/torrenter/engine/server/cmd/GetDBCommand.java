package xyz.morecraft.dev.xross.torrenter.engine.server.cmd;

import xyz.morecraft.dev.xross.torrenter.engine.server.Server;
import xyz.morecraft.dev.xross.torrenter.engine.server.dto.CommunicationException;

import java.io.IOException;
import java.io.ObjectOutputStream;

public class GetDBCommand extends ServerCommand {

    @Override
    public void run(Server server, ObjectOutputStream outputStream) {
        try {
            outputStream.writeObject(new CommunicationException("Command not implemented yet"));
        } catch (IOException e) {
            log.error("Error", e);
        }
    }

}
