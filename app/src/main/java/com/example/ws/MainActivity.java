package com.example.ws;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ws.server.messaging.MessagingCallback;
import com.example.ws.server.messaging.MessagingRepository;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.DeploymentException;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class MainActivity extends Activity {
    MyApplication myApplication;
    MessagingRepository messagingRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myApplication = (MyApplication) getApplication();
        messagingRepository = new MessagingRepository(myApplication.getExecutorService());

        TextView text = findViewById(R.id.text);

        messagingRepository.connectToWebSocket(new MessagingCallback() {
            @Override
            public void onComplete(Session session) {
                session.addMessageHandler(ByteBuffer.class, message -> {
                    runOnUiThread(() -> {
                        text.setText(text.getText().toString() + "\n");
                        message.rewind();
                        while (message.hasRemaining()) {
                            text.setText(text.getText().toString() + (char) message.get());
                        }
                    });
                });
            }

            @Override
            public void onError(DeploymentException e) {
                Toast.makeText(getParent(), "Could not connect to the server.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(IOException e) {
                Toast.makeText(getParent(), "Could not connect to the server.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}