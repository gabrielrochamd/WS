package com.example.ws.server.messaging;

import java.io.IOException;

import javax.websocket.DeploymentException;
import javax.websocket.Session;

public interface MessagingCallback {
    void onComplete(Session session);
    void onError(DeploymentException e);
    void onError(IOException e);
}
