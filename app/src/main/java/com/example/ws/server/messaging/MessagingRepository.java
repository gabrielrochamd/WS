package com.example.ws.server.messaging;

import android.util.Log;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;
import java.util.concurrent.Executor;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class MessagingRepository {
    private static final String MESSAGING_URI = "ws://192.168.0.101:8080";

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
                Log.d("WEB_SOCKET", "Success");
                callback.onComplete(session);
            } catch (DeploymentException e) {
                Log.e("WEB_SOCKET", "Error");
                e.printStackTrace();
                callback.onError(e);
            } catch (IOException e) {
                Log.e("WEB_SOCKET", "Error");
                e.printStackTrace();
                callback.onError(e);
            }
        });
    }
}
