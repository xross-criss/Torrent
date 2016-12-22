package xyz.morecraft.dev.xross.torrenter.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.morecraft.dev.xross.torrenter.constants.FileConstants;
import xyz.morecraft.dev.xross.torrenter.engine.FileEntry;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public final class FileEntryUtil {

    private final static Logger log = LoggerFactory.getLogger(FileEntryUtil.class);

    public static FileEntry getFileEntry(File f) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            try (InputStream is = new FileInputStream(f)) {
                byte[] buffer = new byte[FileConstants.DEFAULT_FILE_PART_SIZE];
                List<FileEntry.FilePart> filePartList = new ArrayList<>();
                int i = 0;
                try (DigestInputStream dis = new DigestInputStream(is, md)) {
                    int read;
                    while ((read = dis.read(buffer)) != -1) {
                        filePartList.add(
                                new FileEntry.FilePart(
                                        ControlSumUtil.md5(buffer),
                                        read,
                                        i++
                                )
                        );
                    }
                }
                return new FileEntry(
                        ControlSumUtil.getHex(md.digest()),
                        f.getName(),
                        System.currentTimeMillis(),
                        filePartList,
                        f.length()
                );
            }
        } catch (Exception e) {
            log.error("Error occurred during hashing file", e);
            return null;
        }
    }

}
