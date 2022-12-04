package com.zuo.nfcproject.lib;

/**
 * Copyright (C), 2022,
 * Author: zuo
 * Date: 2022-08-21 15:16
 * Description:
 */
class userThreadLocl {


    private static ThreadLocal<String> stringThreadLocal;

    /**
     * 运行3个线程
     */
    public void StartThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestThread(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    /**
     * 类说明：测试线程，线程的工作是将ThreadLocal变量的值变化，并写回，看看线程之间是否会互相影响
     */
    public static class TestThread implements Runnable {
        private static ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 1;
            }
        };
        private static ThreadLocal<Integer> intLocal2 = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 2;
            }
        };

        private static ThreadLocal<Integer> intLocal3 = new ThreadLocal<Integer>() {
            @Override
            protected Integer initialValue() {
                return 3;
            }
        };


        int id;

        public TestThread(int id) {
            this.id = id;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start");
            sop(intLocal);
            sop(intLocal2);
            sop(intLocal3);

            //intLocal.remove();
        }

        private void sop(ThreadLocal threadLocal) {

            Integer s = (Integer) threadLocal.get();
            s = s + id;
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName()
                    + ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        userThreadLocl test = new userThreadLocl();
        test.StartThreadArray();
    }


}
