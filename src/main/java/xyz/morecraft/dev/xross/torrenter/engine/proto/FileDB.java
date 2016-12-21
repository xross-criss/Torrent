package xyz.morecraft.dev.xross.torrenter.engine.proto;

import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;

import java.util.HashMap;

public interface FileDB {

    void add(String string, FileEntry FE);

    int size();

    HashMap<String, FileEntry> getMap();

    void delete(String string, FileEntry FE);

    void clear();

}

