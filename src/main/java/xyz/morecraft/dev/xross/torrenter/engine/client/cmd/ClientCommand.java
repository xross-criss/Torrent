package xyz.morecraft.dev.xross.torrenter.engine.client.cmd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.morecraft.dev.xross.torrenter.engine.client.Client;

public abstract class ClientCommand {

    protected static final Logger log = LoggerFactory.getLogger(ClientCommand.class);

    private final String name;

    ClientCommand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(Client client, String content);

    public boolean check(String command) {
        return command.equalsIgnoreCase(name);
    }

}
