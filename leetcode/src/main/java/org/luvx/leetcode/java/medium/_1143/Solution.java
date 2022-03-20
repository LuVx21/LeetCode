package org.luvx.leetcode.java.medium._1143;
/*
 * @lc app=leetcode.cn id=1143 lang=java
 *
 * [1143] 最长公共子序列
 */

// @lc code=start
class Solution {
    /**
     * 仅输出最长序列的长度
     * https://blog.csdn.net/hrn1216/article/details/51534607
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) {
            return longestCommonSubsequence1(text2, text1);
        }
        int[][] dp = new int[2][n + 1];
        for (int i = 0, k = 1; i < m; ++i, k ^= 1) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[k][j + 1] = 1 + dp[k ^ 1][j];
                } else {
                    dp[k][j + 1] = Math.max(dp[k ^ 1][j + 1], dp[k][j]);
                }
            }
        }
        return dp[m % 2][n];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        if (m < n) {
            return longestCommonSubsequence2(text2, text1);
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0, prevRow = 0, prevRowPrevCol = 0; j < text2.length(); j++) {
                prevRowPrevCol = prevRow;
                prevRow = dp[j + 1];
                dp[j + 1] = text1.charAt(i) == text2.charAt(j) ? prevRowPrevCol + 1 : Math.max(dp[j], prevRow);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        System.out.println(exec.longestCommonSubsequence("abcde", "ace"));
        // System.out.println(exec.longestCommonSubsequence("abcfbc", "abfcab"));
        // System.out.println(exec.longestCommonSubsequence("programming", "contest"));
        // System.out.println(exec.longestCommonSubsequence("abcd", "mnp"));
    }
}
// @lc code=end

