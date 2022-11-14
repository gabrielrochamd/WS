package com.example.ws.server.messaging;

import javax.websocket.Session;

public interface MessagingCallback {
    void onComplete(Session session);
}
