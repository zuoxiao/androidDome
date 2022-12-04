package com.example.androiddome;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Collections;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/3/4 8:55
 * Description:
 */
public class TestHandler extends Activity {

    private Handler handler;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Message message = new Message();
//                message.what = 1;
//                message.obj = "收到消息";
//                handler.sendMessage(message);
//            }
//        });
//        new TestThread().start();
        handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
//                textView.setText("收到消息");
            }
        });
//        handler.postDelayed()
//        handler.postAtTime()
//        Collections.synchronizedList()
        
    }


    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacksAndMessages(null);


    }

    private class TestThread extends Thread {
        @Override
        public void run() {

//            Looper.prepare();
            handler = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(Message msg) {

                    Log.i("TestThread", "TestThreadTestThreadTestThreadTestThread");
                    return false;
                }
            });
            Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                }
            };
            Message message = Message.obtain(handler);

//            Looper.loop();
            super.run();
        }

    }

}
