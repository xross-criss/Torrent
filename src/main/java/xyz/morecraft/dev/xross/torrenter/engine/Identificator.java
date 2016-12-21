package xyz.morecraft.dev.xross.torrenter.engine;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public final class Identificator {

    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }

    public static String randomString() { //TODO - do sprawdzenia
        int length = 5;
        char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return String.valueOf(result);
    }
}

