package com.ghlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 反转整数。
 * 1、处理负数
 * 2、处理低位是0
 * 3、处理反转后溢出
 */
public class ReverseInteger {
    public static int reverse(int i) {
        if (i == 0) {
            return 0;
        }
        boolean isPositive = i > 0;
        String istr = String.valueOf(i);
        char[] reverseChars = new char[istr.length()];
        boolean isStart = false;
        int stopIndex = isPositive ? 0 : 1;
        int len = 0;
        for (int j = istr.length() - 1; j >= stopIndex ; j--) {
            if (istr.charAt(j) == '0' && !isStart) {
                continue;
            }
            if (!isStart) {
                isStart = true;
            }
            reverseChars[len++] = istr.charAt(j);
        }
        if (reverseChars.length == 0) {
            return 0;
        }

        char[] destChars = new char[len];
        System.arraycopy(reverseChars, 0, destChars, 0, len);
        Long tmp = Long.valueOf(String.valueOf(destChars));
        if (isPositive) {
            return tmp > Integer.MAX_VALUE ? 0 : tmp.intValue();
        } else {
            return (tmp * -1) < Integer.MIN_VALUE ? 0 : tmp.intValue() * -1;
        }
    }

    public static int reverse1(int x) {
        if (x == 0) {
            return 0;
        }

        boolean isPositive = x > 0;
        int checkPop = isPositive ? 7 : 8;

        int result = 0;
        int positiveCheckNum = Integer.MAX_VALUE / 10;
        int negativeCheckNum = Integer.MIN_VALUE / 10;
        int rev = 0;

        x = Math.abs(x);
        while (x > 0) {
            int pop = x % 10;
            x /= 10;

            // 此处rev * 10可能溢出
            if (rev > positiveCheckNum) {
                return 0;
            } else if (rev == positiveCheckNum && pop > checkPop) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return isPositive ? rev : -1 * rev;
    }

    public static void main(String[] args) {
        System.out.println(-1 % 10);

        System.out.println(reverse(Integer.MAX_VALUE));
        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(reverse(0));
        System.out.println(reverse(1200));
        System.out.println(reverse(12345));
        System.out.println(reverse(-12345));

        System.out.println("--------------------------");

        System.out.println(reverse1(Integer.MAX_VALUE));
        System.out.println(reverse1(Integer.MIN_VALUE));
        System.out.println(reverse1(0));
        System.out.println(reverse1(1200));
        System.out.println(reverse1(-12345));
    }
}
