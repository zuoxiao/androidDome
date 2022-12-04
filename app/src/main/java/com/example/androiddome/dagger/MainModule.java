package com.example.androiddome.dagger;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/3/21 13:13
 * Description:
 */
@Module
public class MainModule {
    @Provides
    Test1 test1(){
        return new Test1();
    }
}
