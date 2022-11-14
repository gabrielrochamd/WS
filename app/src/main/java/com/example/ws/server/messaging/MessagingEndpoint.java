package com.example.ws.server.messaging;

import android.util.Log;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.Session;

public class MessagingEndpoint extends Endpoint {
    @Override
    public void onOpen(Session session, EndpointConfig config) {
        Log.d("SERVER", "Messaging Endpoint connected!");
    }
}
