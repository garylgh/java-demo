package com.ghlin.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

// LinkedBlockingQueue 是一个双向阻塞队列
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> bd = new LinkedBlockingQueue<>(3);
        Thread comsumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(bd.poll());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        Thread producer = new Thread(new Runnable() {
            private int count = 0;
            @Override
            public void run() {
                while (true) {
                    System.out.println("size: " + bd.size());
                    boolean r = false;
                    try {
                        bd.put(count++);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        comsumer.start();
        producer.start();
    }
}
