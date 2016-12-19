package xyz.morecraft.dev.xross.torrenter.engine.proto;

import java.util.Objects;

public class HashableFile {

    private final String controlSum;

    public HashableFile(String controlSum) {
        if (Objects.isNull(controlSum)) {
            throw new NullPointerException("Field controlSum cannot be null");
        }
        this.controlSum = controlSum;
    }

    public String getControlSum() {
        return controlSum;
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
