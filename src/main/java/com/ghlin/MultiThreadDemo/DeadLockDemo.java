package com.ghlin.MultiThreadDemo;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo implements Runnable{
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int lock;
    public DeadLockDemo(int lock) {
        this.lock = lock;
    }

    public void run() {
        try {
            if (this.lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        DeadLockDemo dld1 = new DeadLockDemo(1);
        DeadLockDemo dld2 = new DeadLockDemo(2);
        Thread t1 = new Thread(dld1);
        Thread t2 = new Thread(dld2);
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        Thread.sleep(1000);
        t2.interrupt();
        System.out.println("==========end");
    }
}
