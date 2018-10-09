package com.ghlin.algorithm;

import java.util.BitSet;

/**
 * 在一个元素为 1 到 100 的整数数组中，如何搜索缺失元素？
 * 使用BitSet
 */
public class MissingNumber1_2 {
    private static int SIZE = 100;
    public static void main(String[] args) {
        int[] numberArr = new int[]{4,5,7,1,45,6,34,60};
        int missingCount = SIZE - numberArr.length;
        BitSet bs = new BitSet(SIZE);

        for (int number : numberArr) {
            bs.set(number);
        }

        int lastMissingIndex = 1;
        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bs.nextClearBit(lastMissingIndex);
            System.out.println(lastMissingIndex++);
        }
    }
}
