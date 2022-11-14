package com.example.ws;

import android.app.Application;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyApplication extends Application {
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public ExecutorService getExecutorService() {
        return executorService;
    }
}
