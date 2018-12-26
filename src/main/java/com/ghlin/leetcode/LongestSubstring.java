package com.ghlin.leetcode;

import java.util.BitSet;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        HashSet<Character> notDupSet = new HashSet<>();

        int start = 0;
        int end = 0;
        int maxLen = 1;

        // for loop
        for (int i = 0; i < s.length(); i++) {
            notDupSet.clear();
            notDupSet.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (notDupSet.contains(s.charAt(j))) {
                    break;
                } else {
                    if ((j - i + 1) > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                        end = j;
                    }
                    notDupSet.add(s.charAt(j));
                }
            }
        }

        System.out.println("start = " + start + ", end = " + end);
        return maxLen;
    }

    public static int lengthOfLongestSubstringWithWhile(String s) {
        int len = s.length();

        HashSet<Character> notDupSet = new HashSet<>();
        int maxLen = 0;
        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            if (!notDupSet.contains(s.charAt(j))) {
                notDupSet.add(s.charAt(j++));
                maxLen = Math.max(maxLen, j - i);
            } else {
                notDupSet.remove(s.charAt(i++));
            }
        }
        System.out.println("maxLen = " + maxLen);
        return maxLen;
    }

}
