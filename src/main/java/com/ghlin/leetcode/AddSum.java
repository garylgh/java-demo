package com.ghlin.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/description/
 */
public class AddSum {
    public static int[] twoSum(int[] nums, int target) {
        long startTime = System.currentTimeMillis();
        if (nums.length < 2) {
            throw new IllegalArgumentException("arguments size must be larger than 2");
        }

        int[] results = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    results[0] = i;
                    results[1] = j;
                    break;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("consume time: " + (endTime - startTime));
        return results;
    }

    public static int[] twoSum1(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("arguments size must be larger than 2");
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 11, 15};
        int target = 9;

        int[] results = twoSum1(nums, target);
        for (int i: results) {
            System.out.println(i);
        }
    }
}
