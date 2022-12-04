package com.example.androiddome.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;

import com.example.androiddome.R;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/4/30 11:07
 * Description:
 */
public class LoaclBroadCast extends Activity {
    LocalBroadcastManager broadcastManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast);
        initCast();
    }


    private void initCast() {
        broadcastManager = LocalBroadcastManager.getInstance(this);

        MyBroadCastReceive myBroadCastReceive = new MyBroadCastReceive();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.broadcast.test");
        broadcastManager.registerReceiver(myBroadCastReceive, intentFilter);
    }

    public void broadCast(View view) {
        Intent intent = new Intent();
        intent.setAction("com.broadcast.test");
        intent.putExtra("", "发视频美好");
        broadcastManager.sendBroadcast(intent);

    }


    class MyBroadCastReceive extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String message = intent.getStringExtra("message");
                Log.i("LoaclBroadCast", "接收到广播消息 action::" + intent.getAction() + "\tmessage:" + message);
            }
        }
    }

}
