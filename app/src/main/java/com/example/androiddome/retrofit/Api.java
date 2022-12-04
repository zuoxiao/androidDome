package com.example.androiddome.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/2/28 18:07
 * Description:
 */
public interface Api {
    @GET("https://api.uomg.com/")
    Call<Data> getData();
}
