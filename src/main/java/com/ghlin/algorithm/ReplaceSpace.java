package com.ghlin.algorithm;

/**
 * 实现一个函数，把字符串中的每个空格都替换成“%20”，已知原位置后面有足够的空余位置，要求改替换过程发生在原来的位置上。
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        String newS = s.replaceAll("\\s", "%20");
        System.out.println(newS);
    }
}
