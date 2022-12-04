package com.zuo.nfcproject.lib;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-08-20 10:07
 * Description:
 */
class TheadTest {

    public static void main(String[] args) throws InterruptedException {
        test();
    }

    private static class myThread extends Thread {

        public myThread() {
        }

        @Override
        public void run() {
            super.run();
            System.out.println("interrupted:" + Thread.interrupted());
//            while (true) {
            while (!isInterrupted()) {
                System.out.println("interrupted内:" + Thread.interrupted());
//                    System.out.println("interrupted:外" + Thread.interrupted());
            }

//            }

        }
    }

    private static void test() throws InterruptedException {


        myThread thread = new myThread();
        thread.start();
        Thread.sleep(20);
        thread.interrupt();
//        thread.interrupted();

        userCall userCall = new userCall();
        FutureTask futureTask = new FutureTask(userCall);
    }

    private static class userCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            return null;
        }
    }
}
