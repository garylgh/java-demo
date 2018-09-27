package com.ghlin.MultiThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaporeDemo implements Runnable {
    final Semaphore sema = new Semaphore(5, true);

    public void run() {
        try {
            sema.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + ": done");
            sema.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemaporeDemo demo = new SemaporeDemo();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
    }
}
