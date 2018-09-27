package com.ghlin.MultiThreadDemo;

public class StaticSingletonDemo {
    private StaticSingletonDemo() {
        System.out.println("StaticSingletonDemo is created.");
    }

    private static int i = 100;
    private static int j = 200;

    private static class SingletonHolder {
        private static StaticSingletonDemo instance = new StaticSingletonDemo();

        public void accessOut() {
            System.out.println(j);
        }
    }

    public static StaticSingletonDemo getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        System.out.println("--------in main");
        StaticSingletonDemo.getInstance();
        System.out.println(i);
    }
}
