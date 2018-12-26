package com.ghlin.leetcode;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainMostWater {
    public static int figureMostWater(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int maxWater = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxWater = Math.max(area, maxWater);
            }
        }

        return maxWater;
    }

    public static int figureMostWater1(int[] height) {
        int head = 0;
        int tail = height.length - 1;

        int maxWater = 0;

        while (head < tail) {
            int area = (tail - head) * Math.min(height[head], height[tail]);
            maxWater = Math.max(maxWater, area);
            if (height[head] < height[tail]) {
                head++;
            } else {
                tail--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(figureMostWater(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(figureMostWater1(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
