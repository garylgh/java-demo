package com.ghlin.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class ConcurrentHashMapDemo {
    public static void errorVersion() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
////                    e.printStackTrace();
//                }
                for (int i = 0; i < 5; i++) {
                    Integer value = count.get("a");
                    if (null == value) {
                        count.put("a", 1);
                    } else {
                        count.put("a", value + 1);
                    }
                }
                endLatch.countDown();
            }
        };
        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void correctVersion() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        final CountDownLatch endLatch = new CountDownLatch(2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                }
                for (int i = 0; i < 5; i++) {
                    Integer oldValue = count.get("a");
                    if (oldValue == null) {
                        count.putIfAbsent("a", 1);
                    } else {
                        count.replace("a", oldValue, oldValue + 1);
                    }
                }
                endLatch.countDown();
            }
        };

        new Thread(task).start();
        new Thread(task).start();

        try {
            endLatch.await();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        errorVersion();
        correctVersion();
    }
}
