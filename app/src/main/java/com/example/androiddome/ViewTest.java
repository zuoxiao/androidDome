package com.example.androiddome;

import android.content.Context;
import android.view.View;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/4/14 10:04
 * Description:
 */
public class ViewTest extends View {
    public ViewTest(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);




    }
}
