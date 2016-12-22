package xyz.morecraft.dev.xross.torrenter.engine.proto;

import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;

import java.util.Collection;

public interface FileDB {

    void add(FileEntry fileEntry);

    int size();

    FileEntry get(String hash);

    void delete(String hash);

    void delete(FileEntry fileEntry);

    boolean contains(String hash);

    boolean contains(FileEntry fileEntry);

    Collection<FileEntry> getAll();

    void clear();

}

