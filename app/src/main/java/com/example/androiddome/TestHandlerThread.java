package com.example.androiddome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/3/4 9:19
 * Description:
 */
public class TestHandlerThread extends Activity {

    Handler workHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = new Message();
                message.obj = "我从主线程来";
                workHandler.sendMessage(message);
            }
        });

        HandlerThread handlerThread = new HandlerThread("handlerThread");
        handlerThread.start();

        workHandler = new Handler(handlerThread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.i("TestHandlerThread", msg.obj + "");
            }
        };


    }


}
