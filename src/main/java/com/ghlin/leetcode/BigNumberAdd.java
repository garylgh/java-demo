package com.ghlin.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BigNumberAdd {
    private static final Pattern p = Pattern.compile("\\D");

    public static String add(String s1, String s2) {
        if (stringIsNotInt(s1) && stringIsNotInt(s2)) {
            return null;
        }

        int s1Len = s1.length();
        int s2Len = s2.length();
        int maxLen = s1Len >= s2Len ? s1Len : s2Len;

        int sum = 0;
        String result = "";

        while (s1Len >= 1 || s2Len >= 1) {
            int s1Val = 0;
            int s2Val = 0;
            if (s1Len > 0) {
                s1Val = Integer.valueOf(s1.substring(s1Len - 1, s1Len));
                s1Len--;
            }
            if (s2Len > 0) {
                s2Val = Integer.valueOf(s2.substring(s2Len - 1, s2Len));
                s2Len--;
            }
            sum += (s1Val + s2Val);
            System.out.println(s1Val + " +  " + s2Val + " = " + sum);

            if (sum >= 10) {
                result = (sum - 10) + result;
                sum = 1;
            } else {
                result = sum + result;
                sum = 0;
            }
        }
        return result;
    }

    private static class DataPojo {
        char currVal;
        char currJinwei;

        public DataPojo(char currVal, char currJinwei) {
            this.currVal = currVal;
            this.currJinwei = currJinwei;
        }
    }

    private static DataPojo jinweiAdd(char a, char b, char jinwei) {
        char currVal = (char)(a + b + jinwei);
        char currJinwei = 0;
        if (currVal >= 10) {
            currVal = (char)(currVal - 10);
            currJinwei = 1;
        } else {
            currJinwei = 0;
        }

        System.out.println(a + " + " + b + " = " + currVal );
        System.out.println(a + " + " + b + " = " + currJinwei );
        return new DataPojo(currVal, currJinwei);
    }

    public static void reverseArray(char[] originArray) {
        int len = originArray.length;
        for (int i = 0; i < len / 2; i++) {
            char tmp = originArray[i];
//            System.out.println("originArray[i] = " + originArray[i]);
//            System.out.println("originArray[len - i - 1] = " + originArray[len - i - 1]);
            originArray[i] = originArray[len - i - 1];
            originArray[len - i - 1] = tmp;
        }
    }

    public static boolean stringIsNotInt(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Matcher matcher = p.matcher(s);
        return matcher.find();
    }

}
