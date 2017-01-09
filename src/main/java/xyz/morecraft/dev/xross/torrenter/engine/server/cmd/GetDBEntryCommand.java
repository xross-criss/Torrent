package xyz.morecraft.dev.xross.torrenter.engine.server.cmd;

import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;
import xyz.morecraft.dev.xross.torrenter.engine.server.Server;
import xyz.morecraft.dev.xross.torrenter.engine.server.dto.CommunicationException;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Objects;

public class GetDBEntryCommand extends ServerCommand {

    private final String id;

    public GetDBEntryCommand(String id) {
        this.id = id;
    }

    @Override
    public void run(Server server, ObjectOutputStream outputStream) {
        FileEntry fileEntry = server.getFileDB().get(id);
        try {
            if (Objects.isNull(fileEntry)) {
                outputStream.writeObject(new CommunicationException("Entry not found"));
            } else {
                outputStream.writeObject(fileEntry);
            }
        } catch (IOException e) {
            log.error("Error", e);
        }
    }

    @Override
    public String toString() {
        return "GetDBEntryCommand{" +
                "id='" + id + '\'' +
                '}';
    }

}
