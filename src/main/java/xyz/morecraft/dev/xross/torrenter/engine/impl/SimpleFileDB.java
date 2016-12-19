package xyz.morecraft.dev.xross.torrenter.engine.impl;

import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

import java.util.ArrayList;
import java.util.List;

public class SimpleFileDB implements FileDB {

    private List<String> list;

    public SimpleFileDB() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(String string) {
        list.add(string);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

}
