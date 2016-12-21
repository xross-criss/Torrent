package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static xyz.morecraft.dev.xross.torrenter.engine.Identificator.randomString;

public class FileProcessor {

    SimpleFileDB SFDB;
    FileEntry FE;

    public void readAllFilesFromFolder(String path) throws IOException, NoSuchAlgorithmException {
        List<File> filesPath = new ArrayList<>();
        HashMap<File, String> FileToMD5Map = new HashMap<>();
        FileReader fileReader = new FileReader(filesPath);
        ChecksumCounter cc = new ChecksumCounter();

        filesPath = fileReader.read(path);

        for (File i : filesPath) {
            FileToMD5Map.put(i, cc.generateMD5checksum(i));
        }

        for (Map.Entry<File, String> entry : FileToMD5Map.entrySet()) {
            File file = entry.getKey();
            String md5 = entry.getValue();

            addon(SFDB, FE, file, md5);
        }
    }

    public void addFile(String path) throws IOException, NoSuchAlgorithmException {
        File file = new File(path);
        ChecksumCounter cc = new ChecksumCounter();

        String md5 = cc.generateMD5checksum(file);

        addon(SFDB, FE, file, md5);
    }

    public void addon(SimpleFileDB SFDB, FileEntry FE, File file, String md5) {
        if (SFDB.size() == 0) {

            new FileEntry(md5, file.getName());
            new SimpleFileDB().add(md5, FE);

            partFile(file);
        } else {
            if (!SFDB.getMap().containsKey(md5)) {
                new FileEntry(md5, file.getName());
                SFDB.add(md5, FE);
            } else {
                String newName = file.getName().concat(randomString());
                new FileEntry(md5, newName);
                SFDB.add(md5, FE);
            }
        }
    }

    private void partFile(File file) {
        double bytes = file.length();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);
        double gigabytes = (megabytes / 1024);

        int partsAmount = 1;

        if (kilobytes <= 1.0) {
            partsAmount = 10;
        } else if (megabytes <= 1.0) {
            partsAmount = 100;
        } else if (gigabytes <= 1.0) {
            partsAmount = 10000;
        } else {
            partsAmount = 1000000;
        }

        //splitFile(file, partsAmount);
    }

/*    private void splitFile(File file, int partsAmount) {

        FileInputStream inputStream;
        String newFileName;
        FileOutputStream filePart;

    }*/

}
