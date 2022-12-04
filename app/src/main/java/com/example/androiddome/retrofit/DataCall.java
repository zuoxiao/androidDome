package com.example.androiddome.retrofit;

import java.io.IOException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/2/28 20:34
 * Description:
 */
public class DataCall {


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.uomg.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    Api api = retrofit.create(Api.class);

    private void call() {
        Call<Data> dataCall = api.getData();
        dataCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {

            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
        try {
            dataCall.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initHttp() {
        OkHttpClient httpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(new MyApplicationInterceptor())

                .build();

    }

}
