package com.ghlin.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的N种方式
 * https://blog.csdn.net/longshengguoji/article/details/41126119
 */
public class ThreadDemo {
    static class FromThreadTest extends Thread {
        FromThreadTest(int i) {
            super("FromThreadTest" + i);
        }
        @Override
        public void run() {
            System.out.println("threadName: " + this.getName());
        }
    }

    static class RunnableThreadTest implements Runnable {
        @Override
        public void run() {
            System.out.println("className: " + Thread.currentThread().getClass().getName());
        }
    }

    static class CallableThreadTest implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return (int)Math.random() * 10;
        }
    }

    public static void main(String[] args) {
        // 第一种方式
        for (int i = 0; i < 3; i++) {
            new FromThreadTest(i).start();
        }

        // 第二种方式
        RunnableThreadTest rtt = new RunnableThreadTest();
        for (int i = 0; i < 3; i++) {
            new Thread(rtt, rtt.getClass().getName() + i).start();
        }

        // 第三种方式
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<Integer>(ctt);

    }
}
