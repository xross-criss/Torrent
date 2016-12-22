package xyz.morecraft.dev.xross.torrenter.engine.impl;

import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;
import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleFileDB implements FileDB {

    private Map<String, FileEntry> stringFileEntryHashMap;

    public SimpleFileDB() {
        this.stringFileEntryHashMap = new ConcurrentHashMap<>();
    }

    @Override
    public void add(FileEntry fileEntry) {
        stringFileEntryHashMap.put(fileEntry.getControlSum(), fileEntry);
    }

    @Override
    public int size() {
        return stringFileEntryHashMap.size();
    }

    @Override
    public FileEntry get(String hash) {
        return stringFileEntryHashMap.get(hash);
    }

    @Override
    public void delete(String hash) {
        stringFileEntryHashMap.remove(hash);
    }

    @Override
    public void delete(FileEntry fileEntry) {
        delete(fileEntry.getControlSum());
    }

    @Override
    public boolean contains(String hash) {
        return stringFileEntryHashMap.containsKey(hash);
    }

    @Override
    public boolean contains(FileEntry fileEntry) {
        return contains(fileEntry.getControlSum());
    }

    @Override
    public Collection<FileEntry> getAll() {
        return stringFileEntryHashMap.values();
    }

    @Override
    public void clear() {
        stringFileEntryHashMap.clear();
    }

}
