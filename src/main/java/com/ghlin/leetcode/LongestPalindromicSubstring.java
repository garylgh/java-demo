package com.ghlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    /**
     * 中心外展法。可能存在2n-1个中心
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        int longest = 1;
        int startIndex = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            int r1 = centerAround(s, i, i);
            int r2 = centerAround(s, i, i + 1);

            int tmpLen = Math.max(r1, r2);
            if (longest < tmpLen) {
                longest = tmpLen;
                if (tmpLen % 2 == 0) {
                    startIndex =  i - ((tmpLen / 2) - 1);
                } else {
                    startIndex =  i - (tmpLen / 2);
                }
            }
        }

        return s.substring(startIndex, startIndex + longest);
    }

    public static int centerAround(String s, int left, int right) {
        int maxLen = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            maxLen = right - left + 1;
            left--;
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
//        String s1 = "abacdgfdcaba";
        String s2 = "cbbd";
//        String s3 = "123456787654321";

//        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));
//        System.out.println(longestPalindrome(s3));
    }
}
