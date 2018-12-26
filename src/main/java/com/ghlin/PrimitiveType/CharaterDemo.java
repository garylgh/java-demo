package com.ghlin.PrimitiveType;

public class CharaterDemo {
    public static void main(String[] args) {
        char c1 = 'a';
        int ci1 = c1;
        System.out.println(ci1);
        System.out.println(Character.codePointAt(new char[]{'a', 'b'}, 1));

        char c2 = 29999;
        System.out.println(c2);

        Character c3 = '中';
        System.out.println((int)c3);
        System.out.println(c3.hashCode());

        char num1 = '1';
        char num2 = '2';

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        int num3 = num1 + num2;
        System.out.println("num3 = " + num3);
        System.out.println(((int)(num1) + (int)num2));

        int num1Int = Integer.parseInt(String.valueOf(num1));
        int num2Int = Integer.parseInt(String.valueOf(num2));
        System.out.println(num1Int);
        System.out.println(num2Int);

        System.out.println(char2LiteralInt('9'));
        System.out.println(char2LiteralInt2('8'));
    }

    /**
     * 将字符转换为
     */
    public static int char2LiteralInt(char c) {
        return  Integer.valueOf(String.valueOf(c));
    }

    public static int char2LiteralInt2(char c) {
        return c - '0';
    }
}
