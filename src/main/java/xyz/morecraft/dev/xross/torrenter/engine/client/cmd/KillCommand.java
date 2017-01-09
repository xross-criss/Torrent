package xyz.morecraft.dev.xross.torrenter.engine.client.cmd;

import xyz.morecraft.dev.xross.torrenter.engine.client.Client;

public class KillCommand extends ClientCommand {

    public KillCommand() {
        super("KILL");
    }

    @Override
    public void run(Client client, String content) {
        System.exit(0);
    }

}
