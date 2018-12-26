package com.ghlin.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class String2Integer {
    public static final char MINOR_CHAR = '-';
    public static final char PLUS_CHAR = '+';
    public static final int CHECK_POSITIVE_INT = Integer.MAX_VALUE / 10;
    public static final int CHECK_NEGATIVE_INT = Integer.MIN_VALUE / 10;

    public static int myAtoi(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        /**
         * 1. 空格后面必须是'-' 或 '1-9'
         */
        char[] validChars = parseNumberChars(s);
        if (validChars.length == 0) {
            return 0;
        }
        return string2Int(validChars);
    }

    public static int string2Int(char[] validChars) {
        boolean isPositive = true;
        int startIdx = 0;
        if (validChars[0] == '-') {
            isPositive = false;
            startIdx = 1;
        }

        int ret = 0;
        for (int i = startIdx; i < validChars.length; i++) {
            int currInt = char2LiteralInt(validChars[i]);
            if (isPositive) {
                if (ret > CHECK_POSITIVE_INT || (ret == CHECK_POSITIVE_INT && currInt > 7)) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (ret > CHECK_POSITIVE_INT || (ret == CHECK_POSITIVE_INT && currInt > 8)) {
                    return Integer.MIN_VALUE;
                }
            }

            ret = ret * 10 + currInt;
        }

        return isPositive ? ret : ret * -1;
    }

    public static int char2LiteralInt(char c) {
        return Integer.valueOf(String.valueOf(c));
    }

    public static char[] parseNumberChars(String s) {
        boolean isStart = false;
        boolean isPositive = true;
        char[] originChars = new char[s.length()];
        int len = 0;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (!isStart) {
                if (c == ' ') {
                    continue;
                } else if (c == MINOR_CHAR || c == PLUS_CHAR || (c >= '0' && c <= '9')) {
                    isStart = true;
                    if (c == MINOR_CHAR) {
                        isPositive = false;
                        originChars[len++] = MINOR_CHAR;
                    }
                    if (c >= '1' && c <= '9') {
                        originChars[len++] = c;
                    }
                    continue;
                }

                break;
            } else {
                if (c >= '0' && c <= '9') {
                    originChars[len++] = c;
                } else {
                    break;
                }
            }
        }

        char[] destChars = new char[len];
        System.arraycopy(originChars, 0, destChars, 0, len);

        return destChars;
    }

    public static int myAtoi2(String str) {
        int index =0, digit = 1;;
        Long total = new Long(0);
        int sign = 1;
        //delete white space -> check the sign -> convert to number -> check overflow

        // check whitespace
        while(index < str.length()  && str.charAt(index) == ' ')
            index++;

        if(index == str.length())
            return (int)(total*sign);

        //check the sign
        if(str.charAt(index) == '-' || str.charAt(index) == '+'){
            sign = str.charAt(index) == '-'?-1 : 1;
            index++;
        }

        // convert to number
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9'){

            digit = str.charAt(index) - '0';
            total = total *10 + digit;
            index++;

            if(total > Integer.MAX_VALUE){
                if(sign ==1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
        }
        return (int)(total*sign);
    }


    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "   -42";
        String s3 = "4193 with words";
        String s4 = "words and 987";
        String s5 = "-91283472332";
        String s6 = "20000000000000000000";
        String s7 = "  0000000000012345678";
        String s8 = "  -0000000000012345678";

        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
        System.out.println(myAtoi(s6));
        System.out.println(myAtoi(s7));
        System.out.println(myAtoi(s8));

        System.out.println("------------");

        System.out.println(myAtoi2(s1));
        System.out.println(myAtoi2(s2));
        System.out.println(myAtoi2(s3));
        System.out.println(myAtoi2(s4));
        System.out.println(myAtoi2(s5));
        System.out.println(myAtoi2(s6));
        System.out.println(myAtoi2(s7));
        System.out.println(myAtoi2(s8));
    }
}
