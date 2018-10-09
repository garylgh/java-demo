package com.ghlin.algorithm;

/**
 * check if two String are Anagram
 * Read more: https://javarevisited.blogspot.com/2013/03/Anagram-how-to-check-if-two-string-are-anagrams-example-tutorial.html#ixzz5T9XmvhKa
 */
public class StringAnagram {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "gfedcba";

        System.out.println("isAnagram: " + isAnagram(s1, s2));
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;


        int length = s1.length();

        for (int i = 0; i < length; i++) {
            if (s1.charAt(i) != s2.charAt(length - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
