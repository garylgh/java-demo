package com.ghlin.RateLimit;

public class LeakyBucket {
    public static void main(String[] args) {
        System.out.println(Integer.SIZE);
        Integer bitCount = Integer.SIZE - 3;
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString((1 << bitCount)));
        System.out.println(Integer.toBinaryString((1 << bitCount) - 1));
        System.out.println(Integer.toBinaryString(-1 << bitCount));
    }
}
