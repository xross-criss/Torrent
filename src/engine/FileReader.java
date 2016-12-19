package engine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {
        public FileReader(String path) throws IOException {
        try(Stream<Path> paths = Files.walk(Paths.get("/Folder"))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    System.out.println(filePath);
                }
            });
        }
    }
}
