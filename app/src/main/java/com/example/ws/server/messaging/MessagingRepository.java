package com.example.ws.server.messaging;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.Executor;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class MessagingRepository {
    private static final String MESSAGING_URI = "ws://localhost:8080";

    private final Executor executor;
    private Session session;
    private final WebSocketContainer webSocketContainer = ContainerProvider.getWebSocketContainer();

    public MessagingRepository(Executor executor) {
        this.executor = executor;
    }

    public void connectToWebSocket(final MessagingCallback callback) {
        executor.execute(() -> {
            try {
                session = webSocketContainer.connectToServer(MessagingEndpoint.class, null, URI.create(MESSAGING_URI));
                callback.onComplete(session);
            } catch (DeploymentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
