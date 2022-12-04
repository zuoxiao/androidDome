package com.example.androiddome.genmethod;

import android.content.Intent;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-08-24 8:39
 * Description:
 */
public class Genmethod {

    public <T extends ArrayList &Comparable& Serializable> T getData(T t) {
        return t;
    }

}
