package com.ghlin.leetcode;

public class RegularExpressionMatching {
    public static final char STAR_P = '*';
    public static final char DOT_P = '.';
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

//        if (!s.isEmpty()) {
//            return false;
//        }

        boolean firstMatch = !s.isEmpty() && isCharMatch(s.charAt(0), p.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == STAR_P) {
//            if (firstMatch) {
//                return isMatch(s.substring(1), p);
//            } else {
//                return isMatch(s, p.substring(2));
//            }

//            return firstMatch ? isMatch(s.substring(1), p) : isMatch(s, p.substring(2));
            return (firstMatch && isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else {
//            return firstMatch ? isMatch(s.substring(1), p.substring(1)) : firstMatch;
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }

    public static boolean isCharMatch(char in, char pa) {
        return in == pa || pa == DOT_P;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("mississippi", "mis*is*p*."));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("ab", ".*"));
    }
}
