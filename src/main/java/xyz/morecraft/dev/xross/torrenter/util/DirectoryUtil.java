package xyz.morecraft.dev.xross.torrenter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class DirectoryUtil {

    private final static Logger log = LoggerFactory.getLogger(DirectoryUtil.class);

    public static List<File> readDirectoryIntoFileList(String path) {
        try {
            return Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Cannot read directory: {}", path, e);
            return new ArrayList<>();
        }
    }

}
