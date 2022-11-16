package com.example.ws.server.messaging;

import java.sql.Blob;

public class MessagingMessage {
    private Blob data;
    private String origin;

    public Blob getData() {
        return data;
    }

    public String getOrigin() {
        return origin;
    }
}
