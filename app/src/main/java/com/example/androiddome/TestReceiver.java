package com.example.androiddome;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/3/2 20:02
 * Description:
 */
class TestReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, intent.getAction().toString(), Toast.LENGTH_LONG).show();
    }
}
