package com.ghlin.algorithm;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */
public class PalindromeDemo {
    public static void main(String[] args) {
        System.out.println(" level is mirror string? " + isPalindrome("level"));
        System.out.println(" noon is mirror string? " + isPalindrome("noon"));
        System.out.println(" haha is mirror string? " + isPalindrome("haha"));
        System.out.println(" a. is mirror string? " + isPalindrome("a."));
        System.out.println("  is mirror string? " + isPalindrome(""));
        System.out.println(" '\"A man, a plan, a canal: Panama\"' is mirror string? " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(" '\"race a car\"' is mirror string? " + isPalindrome("race a car"));
        System.out.println(" ., is mirror string? " + isPalindrome(".,"));

    }

    static int numberStart = Character.valueOf('0').hashCode();
    static int numberEnd = Character.valueOf('9').hashCode();
    static int charStart = Character.valueOf('a').hashCode();
    static int charEnd = Character.valueOf('z').hashCode();

    public static boolean isValidChar(char c) {
        if ((c >= numberStart && c <=numberEnd) || (c >= charStart && c <= charEnd)) {
            return true;
        }

        return false;
    }

    public static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        if ("".equals(s)) {
            return true;
        }
        s = s.toLowerCase();

        boolean result = false;

        int slen = s.length();
        int start = 0;
        int end = slen - 1;
        while (start < end) {
            char schar = s.charAt(start);
            char echar = s.charAt(end);

            while (!isValidChar(schar)) {
                start++;
                if (start > end) {
                    break;
                }
                schar = Character.toLowerCase(s.charAt(start));
            }

            while (!isValidChar(echar)) {
                end--;
                if (start > end) {
                    break;
                }
                echar = Character.toLowerCase(s.charAt(end));
            }

            if (start > end || schar != echar) {
                result = false;
                break;
            }

            start++;
            end--;
        }

        return result;
    }
}
