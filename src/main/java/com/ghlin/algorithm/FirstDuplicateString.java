package com.ghlin.algorithm;

/**
 * 新浪面试题：编写一个方法，计算一个字符串中，第一个不重复的字符在当前字符串中的索引。
 */
public class FirstDuplicateString {
    public static String s = "abuacdeaudbdfcefhph";

    public static void main(String[] args) {
        int[] container = new int[128];
        for (int i = 0; i < s.length(); i++) {
            int index = Character.valueOf(s.charAt(i)).hashCode();
            container[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = Character.valueOf(s.charAt(i)).hashCode();
            if (container[index] == 1) {
                System.out.println(i);
                System.out.println(s.charAt(i));
            }
        }

        for (int i = 0; i < container.length; i++) {

        }
    }
}
