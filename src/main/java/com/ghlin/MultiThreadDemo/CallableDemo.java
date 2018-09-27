package com.ghlin.MultiThreadDemo;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException{
        Callable callable=()->{
            Thread.sleep(10000);
            System.out.println("haha");
            return 100000;
        };
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future future=executorService.submit(callable);
        Thread.sleep(1000);
        System.out.println("is Done :"+future.isDone());
        try {
            System.out.println(future.get());//阻塞方法
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("is Done :"+future.isDone());
    }
}
