package com.example.androiddome.rxjava;

import android.graphics.Bitmap;

import org.reactivestreams.Subscription;

import java.util.Map;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022/3/28 14:06
 * Description:
 */
public class RxJavaTest {

//    Observable observable = ;

    Observer<Integer> observer = new Observer<Integer>() {
        @Override
        public void onSubscribe(@NonNull Disposable d) {
            d.dispose();
        }

        @Override
        public void onNext(@NonNull Integer integer) {

        }

        @Override
        public void onError(@NonNull Throwable e) {

        }

        @Override
        public void onComplete() {

        }
    };


    private void subscribe() {
//        observable.subscribe(observer);

        RxJavaPlugins.setInitSingleSchedulerHandler(new Function<Supplier<Scheduler>, Scheduler>() {
            @Override
            public Scheduler apply(Supplier<Scheduler> schedulerSupplier) throws Throwable {
                return null;
            }
        });


        Observable
                .create(new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        })
                .map(new Function<Integer, Bitmap>() {
            @Override
            public Bitmap apply(Integer o) throws Throwable {
                return null;
            }
        })
                .unsubscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())//以上代码执行的线程
                .observeOn(AndroidSchedulers.mainThread())//以下代码执行的线程
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Bitmap integerStringMap) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        FlowableSubscriber flowableSubscriber=new FlowableSubscriber() {
            @Override
            public void onSubscribe(@NonNull Subscription s) {

            }

            @Override
            public void onNext(Object o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };
        Flowable.just("","","").subscribe();
//        Observable observable= Observable.just();
    }


}