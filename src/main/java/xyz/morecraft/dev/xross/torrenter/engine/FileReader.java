package xyz.morecraft.dev.xross.torrenter.engine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    private List<File> filesInFolder = new ArrayList<>();

    public FileReader(List<File> filesInFolder) {
        this.filesInFolder = filesInFolder;
    }


    List<File> read(String path) throws IOException {
        filesInFolder = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        return filesInFolder;
    }
}
