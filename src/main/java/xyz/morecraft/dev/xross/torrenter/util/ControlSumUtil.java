package xyz.morecraft.dev.xross.torrenter.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class ControlSumUtil {

    private final static Logger log = LoggerFactory.getLogger(ControlSumUtil.class);

    public static String md5(byte[] bytes) {
        try {
            return getHex(MessageDigest.getInstance("MD5").digest(bytes));
        } catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithmException: MD5", e);
        }
        return null;
    }

    public static String getHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            if ((0xff & b) < 0x10) {
                hexString.append("0").append(Integer.toHexString((0xFF & b)));
            } else {
                hexString.append(Integer.toHexString(0xFF & b));
            }
        }
        return hexString.toString();
    }

}
