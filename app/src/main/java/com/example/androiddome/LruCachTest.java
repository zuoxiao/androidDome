package com.example.androiddome;

import android.graphics.Bitmap;
import android.util.LruCache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/6/30 11:00
 * Description:
 */
public class LruCachTest {


    public void add(){
        LruCache lruCache=new LruCache<String, Bitmap>(5){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }

        };

    }
}
