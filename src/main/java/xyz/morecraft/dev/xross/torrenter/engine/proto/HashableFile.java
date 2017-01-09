package xyz.morecraft.dev.xross.torrenter.engine.proto;

import java.io.Serializable;
import java.util.Objects;

public class HashableFile implements Serializable {

    private final String controlSum;
    private long size;

    public HashableFile(String controlSum) {
        if (Objects.isNull(controlSum)) {
            throw new NullPointerException("Field controlSum cannot be null");
        }
        this.controlSum = controlSum;
    }

    public HashableFile(String controlSum, long size) {
        this.controlSum = controlSum;
        this.size = size;
    }

    public String getControlSum() {
        return controlSum;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashableFile that = (HashableFile) o;

        return controlSum.equalsIgnoreCase(that.controlSum);
    }

    @Override
    public int hashCode() {
        return controlSum.hashCode();
    }

}
