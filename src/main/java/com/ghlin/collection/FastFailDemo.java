package com.ghlin.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FastFailDemo {
    private static List<String> list = new ArrayList();

    public static void main(String[] args) {
        list.add("a");
        list.add("b");
        list.add("c");
        new ThreadOne().start();
        new ThreadTwo().start();
    }

    private static class ThreadOne extends Thread {
        public ThreadOne() {
            this.setName("THREAD ONE");
        }
        @Override
        public void run() {
            for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
                System.out.println("Thread " + Thread.currentThread().getName() + ": " + iter.next());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {
        public ThreadTwo() {
            this.setName("THREAD TWO");
        }

        @Override
        public void run() {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
            }

            list.add("threadtwo" + Math.random());
        }
    }
}
