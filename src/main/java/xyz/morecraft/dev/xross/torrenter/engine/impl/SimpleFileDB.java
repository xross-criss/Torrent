package xyz.morecraft.dev.xross.torrenter.engine.impl;

import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;
import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

import java.util.HashMap;

public class SimpleFileDB implements FileDB {

    //private List<String> list;
    HashMap<String, FileEntry> SFDBMap;

    public SimpleFileDB() {
        this.SFDBMap = new HashMap<>();
    }

    @Override
    public void add(String string, FileEntry FE) {
        SFDBMap.put(string, FE);
    }

    @Override
    public int size() {
        return SFDBMap.size();
    }

    @Override
    public HashMap<String, FileEntry> getMap() {
        return this.SFDBMap;
    }

    @Override
    public void delete(String string, FileEntry FE) {
        SFDBMap.remove(string, FE);
    }

    @Override
    public void clear() {
        SFDBMap.clear();
    }

}
