package com.example.androiddome.reclycler;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-09-14 21:47
 * Description:
 */
public class StarAdapter extends RecyclerView.Adapter {
    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public boolean isGourpHeader(int position) {
        if (position == 0) {
            return true;

        } else {

            return false;
        }

    }
}
