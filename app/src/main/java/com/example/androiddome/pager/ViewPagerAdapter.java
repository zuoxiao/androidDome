package com.example.androiddome.pager;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.androiddome.R;

import java.util.List;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-09-01 23:02
 * Description:
 */
public class ViewPagerAdapter extends PagerAdapter {

    private static final String TAG = "MyPagerAdapter";
    private List<Integer> mImages;
    private Context mContext;

    ViewPagerAdapter(List<Integer> images, Context context) {
        mImages = images;
        mContext = context;
    }
    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mImages.size();
        View view = LayoutInflater.from(mContext).inflate(R.layout.linear_item, container, false);
        TextView textView = view.findViewById(R.id.tv);
        textView.setText(position + " ");
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
