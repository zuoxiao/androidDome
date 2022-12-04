package com.example.androiddome.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-09-02 10:26
 * Description:
 */
public class MyViewPager extends ViewPager {
    public MyViewPager(@NonNull  Context context) {
        super(context);
    }
    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
   int height=0;
        for (int i = 0; i < getChildCount(); i++) {
            View childView =getChildAt(i);
            ViewGroup.LayoutParams params=childView.getLayoutParams();

            int childwith=getChildMeasureSpec(widthMeasureSpec,0,params.width);
            int childheight=getChildMeasureSpec(heightMeasureSpec,0,params.height);
            childView.measure(childwith,childheight);
            int h = childView.getMeasuredHeight();
            if (h > height) {
                height = h;
            }
        }
        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
