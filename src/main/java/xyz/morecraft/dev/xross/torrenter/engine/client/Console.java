package xyz.morecraft.dev.xross.torrenter.engine.client;

import xyz.morecraft.dev.xross.torrenter.engine.client.cmd.ClientCommand;
import xyz.morecraft.dev.xross.torrenter.engine.client.cmd.DefaultCommand;
import xyz.morecraft.dev.xross.torrenter.engine.client.cmd.KillCommand;
import xyz.morecraft.dev.xross.torrenter.engine.client.cmd.PushCommand;

import java.util.Scanner;
import java.util.TreeMap;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Console {

    private static ClientCommand[] ALL_COMMANDS = {
            new KillCommand(),
            new PushCommand()
    };

    private static ClientCommand DEFAULT_COMMAND = new DefaultCommand();

    private TreeMap<String, ClientCommand> commandMap;

    public Console() {
        commandMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (ClientCommand command : ALL_COMMANDS) {
            commandMap.put(
                    command.getName(),
                    command
            );
        }
    }

    private static final int POOL_SIZE = 5;
    //private static final ExecutorService WORKERS = new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE, 1, MILLISECONDS, new LinkedBlockingDeque<>());

    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String inputLine = sc.nextLine();
            String[] parts = inputLine.split("\\s", 2);
            String tmp = null;
            if (parts.length == 2) {
                tmp = parts[1];
            }
            commandMap.getOrDefault(parts[0], DEFAULT_COMMAND).run(new Client(), tmp);
        }
    }

    private static Runnable newExpensiveTask() {
        return () -> {
            try {
                MILLISECONDS.sleep(10000);
                System.out.println("Done processing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
