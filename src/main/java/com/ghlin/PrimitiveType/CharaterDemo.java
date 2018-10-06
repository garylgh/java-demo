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


    }
}
