package xyz.morecraft.dev.xross.torrenter.engine;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Console {
    private static final int POOL_SIZE = 5;
    //private static final ExecutorService WORKERS = new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE, 1, MILLISECONDS, new LinkedBlockingDeque<>());

    public static void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String inputLine = sc.nextLine();
            String[] parts = inputLine.split("\\s");
            String cmd = parts[0];
            String arg = parts[1];


            switch (cmd) {
                case "process":
                 //   WORKERS.submit(newExpensiveTask());
                    break;

                case "kill":
                    System.exit(0);

                case "PUSH":
                    ; //TODO

                case "PULL":
                    ; // TODO

                case "LIST":
                    ; // TODO

                case "switch":
                    switch (parts[1]){
                        case "version":
                            switch (parts[2]){
                                case "H2H":
                                    ;

                                case "MH":
                                    ;

                                default:
                                    System.err.println("Unrecognized version" + parts[2]);
                            };

                        default:
                            System.err.println("Unrecognized switch parameter: " + parts[1]);
                    };

                case "show":
                    switch (parts[1]){
                        case "details":
                            ;

                        case "connections":
                            ;

                        case "log":
                            ;

                        default:
                            System.err.println("Unrecognized show parameter: " + parts[1]);
                    };

                case "set":
                    switch (parts[1]){
                        case "directory":
                            ; // TODO

                        case "UDP":
                            switch (parts[2]){
                                case "on":
                                    ;

                                case "off":
                                    ;

                                default:
                                    System.err.println("Unrecognized parameter for UDP settings: " + parts[2]);
                            }

                        default:
                            System.err.println("Unrecognized set parameter: " + parts[1]);
                    }
                    ; // TODO

                case "validate":
                    switch (parts[1]){
                        case "file":
                            ;

                        case "files-all":
                            ;

                        default:
                            System.err.println("Unrecognized parametr to be validated: " + parts[1]);
                    };

                default:
                    System.err.println("Unrecognized command: " + cmd);
            }
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
