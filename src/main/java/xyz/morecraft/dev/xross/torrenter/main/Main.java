package xyz.morecraft.dev.xross.torrenter.main;

import xyz.morecraft.dev.xross.torrenter.engine.FileProcessor;
import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;
import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

public class Main {

    public static void main(String[] args) {

        FileDB fileDB = new SimpleFileDB();

        FileProcessor fileProcessor = new FileProcessor(fileDB);

        fileProcessor.loadAllFilesFromFolder("C:\\dev\\private\\git\\Torrenter\\src");

        fileDB.getAll().forEach(
                fileEntry -> {
                    System.out.println(fileEntry.toString());
                }
        );

    }

}
