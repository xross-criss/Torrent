package xyz.morecraft.dev.xross.torrenter.engine;

import java.math.BigInteger;
import java.security.SecureRandom;

public final class Identificator {

    private SecureRandom random = new SecureRandom();

    public String nextSessionId() {
        return new BigInteger(130, random).toString(32);
    }
}

