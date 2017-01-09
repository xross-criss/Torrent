package xyz.morecraft.dev.xross.torrenter.engine.client.cmd;

import xyz.morecraft.dev.xross.torrenter.engine.client.Client;

public class DefaultCommand extends ClientCommand {

    public DefaultCommand() {
        super("");
    }

    @Override
    public void run(Client client, String content) {
        log.warn("ClientCommand not found!");
        //client.getTcpClient().executeCommand();
    }

}
