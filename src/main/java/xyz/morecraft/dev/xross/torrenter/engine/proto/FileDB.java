package xyz.morecraft.dev.xross.torrenter.engine.proto;

import java.util.List;

public interface FileDB {

    void add(String string);

    int size();

    List<String> getList();

    void delete(String string);

    void clear();

}

