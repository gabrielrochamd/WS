package com.example.ws;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ws.server.messaging.MessagingCallback;
import com.example.ws.server.messaging.MessagingRepository;

import javax.websocket.Session;

public class MainActivity extends Activity {
    MyApplication myApplication = (MyApplication) getApplication();
    MessagingRepository messagingRepository = new MessagingRepository(myApplication.getExecutorService());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messagingRepository.connectToWebSocket(new MessagingCallback() {
            @Override
            public void onComplete(Session session) {
                Toast.makeText(myApplication, "Session created successfully!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}