package com.ghlin.leetcode;

/**
 * 查找两个字符串的最长公共子串
 * 参考1： https://www.cnblogs.com/ider/p/longest-common-substring-problem-optimization.html
 */
public class LongestCommonSubstring {
    /**
     * 暴力解法
     */
    public static String lcs1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return "";
        }
        int comparisons = 0;
        int longest = 0;
        int startIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                // 查找最长子串
                int length = 0;
                int m = i;
                int n = j;
                while (m < s1.length() && n < s2.length()) {
                    comparisons++;
                    if (s1.charAt(m++) == s2.charAt(n++)) {
                        length++;
                    } else {
                        break;
                    }
                }
                if (length > longest) {
                    longest = length;
                    startIndex = i;
                }
            }

        }
        System.out.println("lcs1比较次数为：" + comparisons);
        return s1.substring(startIndex, startIndex + longest);
    }

    /**
     * 假设两个字符串分别为s和t，s[i]和t[j]分别表示其第i和第j个字符(字符顺序从0开始)，再令L[i, j]表示以s[i]和t[j]为结尾的相同子串的最大长度。
     * 应该不难递推出L[i, j]和L[i+1,j+1]之间的关系，因为两者其实只差s[i+1]和t[j+1]这一对字符。
     * 若s[i+1]和t[j+1]不同，那么L[i+1, j+1]自然应该是0，因为任何以它们为结尾的子串都不可能完全相同；
     * 而如果s[i+1]和t[j+1]相同，那么就只要在以s[i]和t[j]结尾的最长相同子串之后分别添上这两个字符即可，这样就可以让长度增加一位。合并上述两种情况，
     * 也就得到L[i+1,j+1]=(s[i]==t[j]?L[i,j]+1:0)这样的关系。
     * @param s1
     * @param s2
     * @return
     */
    public static String lcs2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return "";
        }

        int comparisons = 0;
        int[][] resultMatrix = new int[s1.length()][s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            comparisons++;
            resultMatrix[0][i] = (s1.charAt(0) == s2.charAt(i)) ? 1 : 0;
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                comparisons++;
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (j == 0) {
                        resultMatrix[i][j] = 1;
                    } else {
                        resultMatrix[i][j] = resultMatrix[i - 1][j - 1] + 1;
                    }
                } else {
                    resultMatrix[i][j] = 0;
                }
            }
        }

        int longest = 0;
        int endIndex = 0;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (resultMatrix[i][j] > longest) {
                    longest = resultMatrix[i][j];
                    endIndex = i;
                }
            }
        }

        System.out.println("lcs2比较次数为：" + comparisons);
        return s1.substring(endIndex - longest + 1, endIndex + 1);
    }

    public static String lcs2_1(String s1, String s2) {
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return "";
        }

        int comparisons = 0;
        int longest = 0;
        int endIndex = 0;

        int[][] resultMatrix = new int[s1.length()][s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            comparisons++;
            if (s1.charAt(0) == s2.charAt(i)) {
                resultMatrix[0][i] = 1;
                longest = 1;
            }
        }

        for (int i = 1; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                comparisons++;
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (j == 0) {
                        resultMatrix[i][j] = 1;
                    } else {
                        resultMatrix[i][j] = resultMatrix[i - 1][j - 1] + 1;
                    }
                    if (longest < resultMatrix[i][j]) {
                        longest = resultMatrix[i][j];
                        endIndex = i;
                    }
                } else {
                    resultMatrix[i][j] = 0;
                }
            }
        }

        System.out.println("lcs2_1比较次数为：" + comparisons);
        return s1.substring(endIndex - longest + 1, endIndex + 1);
    }

    public static void main(String[] args) {
        String s1 = "123214765210";
        String s2 = "321478791432";

        System.out.println(lcs1(s1, s2));
        System.out.println(lcs2(s1, s2));
        System.out.println(lcs2_1(s1, s2));
    }
}
