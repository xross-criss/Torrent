package xyz.morecraft.dev.xross.torrenter.engine;

import xyz.morecraft.dev.xross.torrenter.engine.proto.HashableFile;

import java.util.ArrayList;
import java.util.List;

public class FileEntry extends HashableFile {

    private String originalFileName;
    private Long timestamp; //data utworzenia, czy czegoś tam
    private List<FilePart> partList;

    public FileEntry(String controlSum, String originalFileName) {
        this(
                controlSum,
                originalFileName,
                System.currentTimeMillis(),
                new ArrayList<>(),
                -1
        );
    }

    public FileEntry(String controlSum, String originalFileName, Long timestamp, List<FilePart> partList, long size) {
        super(controlSum, size);
        this.originalFileName = originalFileName;
        this.timestamp = timestamp;
        this.partList = partList;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public int partCount() {
        return partList.size();
    }

    public boolean addPart(FilePart filePart) {
        return this.partList.add(filePart);
    }

    public boolean removePart(FilePart filePart) {
        return this.partList.remove(filePart);
    }

    public static class FilePart extends HashableFile {

        private int order;

        public FilePart(String controlSum, int order) {
            super(controlSum);
            this.order = order;
        }

        public FilePart(String controlSum, long size, int order) {
            super(controlSum, size);
            this.order = order;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        @Override
        public String toString() {
            return "FilePart{" +
                    "controlSum=" + getControlSum() +
                    ", order=" + order +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "FileEntry{" +
                "controlSum=" + getControlSum() +
                ", originalFileName=" + originalFileName +
                ", timestamp=" + timestamp +
                ", partList=" + partList +
                '}';
    }

}
