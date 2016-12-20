package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.impl.SimpleFileDB;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileProcessor {

    SimpleFileDB SFDB = new SimpleFileDB();
    FileEntry FE;

    public void readAllFilesFromFolder(String path) throws IOException, NoSuchAlgorithmException {
        List<File> filesPath = new ArrayList<>();
        HashMap<File, String> FileToMD5Map = new HashMap<>();
        FileReader fileReader = new FileReader(filesPath);
        ChecksumCounter cc = new ChecksumCounter();

        filesPath = fileReader.read(path);

        for (File i : filesPath){
            FileToMD5Map.put(i, cc.generateMD5checksum(i));
        }

        if(SFDB.size() == 0){
            for(Map.Entry<File, String> entry : FileToMD5Map.entrySet()){
                File file = entry.getKey();
                String md5 = entry.getValue();

                //SFDB.add(String.valueOf(new FileEntry(md5, file.toString()))); TODO - check the whole function!
                SFDB.add(path);
                new FileEntry(md5, path);
                partFile(file);
            }

        }

/*        for (int i = 0; i< FileToMD5Map.size(); i++){
            for (int i = 0; i <  ){

            }
        }*/

    }

    private void partFile(File file) {
        double bytes = file.length();
        double kilobytes = (bytes / 1024);
        double megabytes = (kilobytes / 1024);
        double gigabytes = (megabytes / 1024);

        if (kilobytes <= 1.0) {
            //TODO - fill the parts, and add them to object + String split z numerem danego parta
        } else if (megabytes <= 1.0) {

        } else if (gigabytes <= 1.0) {

        } else {

        }
    }

}
