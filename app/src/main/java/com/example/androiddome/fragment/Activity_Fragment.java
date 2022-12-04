package com.example.androiddome.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.androiddome.R;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/7/20 19:41
 * Description:
 */
public class Activity_Fragment extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        Fragment fragment1 = new Fragment1("Fragment1");
//        Fragment1 fragment2 = new Fragment1("fragment2");
//        Fragment1 fragment3 = new Fragment1("fragment3");
        fragmentTransaction.add(R.id.fragment_centent, fragment1, "Fragment1");
//        fragmentTransaction.add(fragment2, "fragment2");
//        fragmentTransaction.add(fragment3, "fragment3");
        fragmentTransaction.commit();

    }
}
