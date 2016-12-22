package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;
import xyz.morecraft.dev.xross.torrenter.engine.proto.HashableFile;

import java.io.*;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static xyz.morecraft.dev.xross.torrenter.engine.Identificator.randomString;

public class FileProcessor {

    SimpleFileDB SFDB;
    FileEntry FE;
    FileEntry.FilePart FP;

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

    public void addon(SimpleFileDB SFDB, FileEntry FE, File file, String md5) throws IOException {
        if (SFDB.size() == 0) {

            new FileEntry(md5, file.getName());
            new SimpleFileDB().add(md5, FE);

            try {
                splitFile(file, FE);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

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

    public void splitFile(File file, FileEntry FE) throws IOException, NoSuchAlgorithmException {
        int partCounter = 1;
        int sizeOfFiles;
        ChecksumCounter cc = new ChecksumCounter();

        if (file.length() <= (1024 * 1024)) {
            sizeOfFiles = 100;
        } else if (file.length() <= (1024 * 1024 * 1024)) {
            sizeOfFiles = 1024 * 1024;
        } else {
            sizeOfFiles = 1024 * 1024 * 100;
        }

        byte[] buffer = new byte[sizeOfFiles];

        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(file))) {
            String name = file.getName();

            int tmp = 0;
            while ((tmp = bis.read(buffer)) > 0) {
/*                File newFile = new File(file.getParent(), name + "."
                        + String.format("%05d", partCounter++));*/

                String md5 = (cc.generateMD5checksum(file));
                HashableFile HF = new HashableFile(md5);
                FP.setOrder(Integer.parseInt(String.format("%05d", partCounter++)));
                FE.addPart(FP); //TODO - coś mi się tu nie podoba - trzeba to sprawdzić!

                try (FileOutputStream out = new FileOutputStream(newFile)) {
                    out.write(tmp);//tmp is chunk size
                }
            }
        }
    }

    public static void mergeFiles(List<File> files, File into)
            throws IOException {
        try (BufferedOutputStream mergingStream = new BufferedOutputStream(
                new FileOutputStream(into))) {
            for (File f : files) {
                Files.copy(f.toPath(), mergingStream);
            }
        }
    }
}
