package com.ghlin.algorithm;

public class StringReverse {
    public static void main(String[] args) {
        String s = "abcdefgh";
        System.out.println(reverse(s));
    }

    public static String reverse(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return s;
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[len - i - 1];
            chars[len - i - 1] = tmp;
        }

        return new String(chars);
    }
}
