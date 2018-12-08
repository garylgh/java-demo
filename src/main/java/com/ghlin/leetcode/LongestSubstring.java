package com.ghlin.leetcode;

import java.util.BitSet;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] ss = s.toCharArray();

        HashSet<Character> notDupSet = new HashSet<>();

        int subStrStart = 0;
        int subStrEnd = 0;
        int maxSize = 1;

        for (int i = 0; i < ss.length; i++) {
            notDupSet.clear();
            notDupSet.add(ss[i]);
            subStrStart = i;
            subStrEnd = i;
            for (int j = i + 1; j < ss.length; j++) {
                if (notDupSet.contains(ss[i])) {
                    maxSize++;
                } else {
                    subStrEnd = j;
                    maxSize++;
                }
            }
        }

        return 0;
    }

}
