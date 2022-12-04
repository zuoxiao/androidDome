package com.example.androiddome;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/2/22 22:29
 * Description:
 */
class TestClass implements TestInterface {

    @Override
    public void test1() {
        int numbers = number;
        WebViewTest viewTest = new WebViewTest();
        Field field;
        try {
            field = WebViewTest.class.getDeclaredField("size");
            field.get(viewTest);

            // 动态拿
            System.out.println(field.get(viewTest));
            // 编译时写死
            System.out.println(viewTest.size);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void test2() {
//        Proxy.newProxyInstance()


    }

    @Override
    public void test3() {

    }
}
