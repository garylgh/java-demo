package com.ghlin.algorithm;

import java.util.regex.Pattern;

public class StringContainNumber {
    public static void main(String[] args) {
        String s1 = "sfsaf";
        String s2 = "sf2s3af";

        Pattern pattern = Pattern.compile("\\d");
        boolean s1Result = pattern.matcher(s1).matches();
        boolean s2Result = pattern.matcher(s2).matches();

        System.out.println("s1 contain number? " + s1Result);
        System.out.println("s2 contain number? " + s2Result);
    }
}
