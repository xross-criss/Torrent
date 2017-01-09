package xyz.morecraft.dev.xross.torrenter.main;

import xyz.morecraft.dev.xross.torrenter.engine.client.Console;

public class Main {

    public static void main(String[] args) {

        Console console = new Console();

        console.run();

//        FileDB fileDB = new SimpleFileDB();
//
//        FileProcessor fileProcessor = new FileProcessor(fileDB);
//
//        fileProcessor.loadAllFilesFromFolder("C:\\dev\\private\\git\\Torrenter\\src");
//
//        fileDB.getAll().forEach(
//                fileEntry -> {
//                    System.out.println(fileEntry.toString());
//                }
//        );

    }

}
