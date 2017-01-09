package xyz.morecraft.dev.xross.torrenter.engine.client.cmd;

import xyz.morecraft.dev.xross.torrenter.engine.client.Client;

public class PushCommand extends ClientCommand {

    public PushCommand() {
        super("PUSH");
    }

    @Override
    public void run(Client client, String content) {
        // TODO
        log.info("PUSH COMMAND");
    }

}
