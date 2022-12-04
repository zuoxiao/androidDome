package com.example.androiddome.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-10-26 11:08
 * Description:
 */
public class JustTest {
    String PATH="";
    private  void regist(){
        Observable.just(PATH).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
//        Flowable.just()
//        Observable.create()
    }
}
