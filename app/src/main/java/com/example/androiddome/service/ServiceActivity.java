package com.example.androiddome.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.example.androiddome.R;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/3/21 17:38
 * Description:
 */
public class ServiceActivity extends Activity {

    StartService.MyBinder myBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("onServiceDisconnected", "onServiceConnected   OtherActivity service disconnect: " + name.getClassName());

            myBinder = (StartService.MyBinder) service;
            StartService startService = myBinder.getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("onServiceDisconnected", "onServiceDisconnected  OtherActivity service disconnect: " + name.getClassName());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service);

    }

    public void start(View view) {
        Intent intent = new Intent(ServiceActivity.this, StartService.class);
        startService(intent);
    }

    public void bind(View view) {
        Intent intent = new Intent(this, StartService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void unBind(View view) {
        Intent intent = new Intent(ServiceActivity.this, StartService.class);
        unbindService(connection);
    }

    public void stop(View view) {
        Intent intent = new Intent(ServiceActivity.this, StartService.class);
        stopService(intent);
    }


}
