package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.proto.FileDB;
import xyz.morecraft.dev.xross.torrenter.util.DirectoryUtil;
import xyz.morecraft.dev.xross.torrenter.util.FileEntryUtil;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class FileProcessor {

    private FileDB fileDB;

    public FileProcessor(FileDB fileDB) {
        this.fileDB = fileDB;
    }

    public void loadAllFilesFromFolder(String path) {
        List<File> fileList = DirectoryUtil.readDirectoryIntoFileList(path);
        for (File file : fileList) {
            addFile(file);
        }
    }

    public void addFile(File file) {
        fileDB.add(
                FileEntryUtil.getFileEntry(file)
        );
    }

    public void addFile(String path) throws IOException, NoSuchAlgorithmException {
        addFile(new File(path));
    }

}
