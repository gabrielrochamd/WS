package com.example.ws.server.messaging;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.HandshakeResponse;

public class MessagingConfigurator extends ClientEndpointConfig.Configurator {
    @Override
    public void afterResponse(HandshakeResponse hr) {
        super.afterResponse(hr);
    }
}
