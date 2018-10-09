package com.ghlin.algorithm;

/**
 * 在一个元素为 1 到 100 的整数数组中，如何搜索缺失元素？
 * 使用位操作
 */
public class MissingNumber1_1 {
    private static int SIZE = 100;
    private static int[] bitArray = new int[SIZE / 32 + 1];

    public static void main(String[] args) {
        int[] numberArr = new int[]{4,5,7,1,45,6,34,60};
        setIntArray(numberArr);
        printLost();
    }
    private static void setIntArray(int[] numberArr)  {
        for (int i = 0; i < numberArr.length; i++) {
            int number = numberArr[i];
            bitArray[number / 32] |= (1 << (number % 32));
        }
    }

    // 判断1到100的比特位上值是否为1
    private static void printLost() {
        for (int i = 1; i <= SIZE; i++) {
            if ((bitArray[i / 32] & (1 << (i % 32))) == 0) {
                System.out.println(i);
            }
        }
    }
}
