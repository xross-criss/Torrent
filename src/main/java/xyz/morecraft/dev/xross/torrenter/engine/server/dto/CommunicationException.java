package xyz.morecraft.dev.xross.torrenter.engine.server.dto;

import java.io.Serializable;

public class CommunicationException implements Serializable {

    private final String message;

    public CommunicationException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "CommunicationException{" +
                "message='" + message + '\'' +
                '}';
    }

}
