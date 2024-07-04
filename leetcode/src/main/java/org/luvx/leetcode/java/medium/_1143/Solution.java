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
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        char[] array1 = text1.toCharArray(), array2 = text2.toCharArray();
        // dp[i][j]: text1[0...i-1]和text2[0...j-1]的最长公共子序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                // 相等:找到一个公共子序列字符, 长度加1
                // 不等:没有找到取最长的
                dp[i + 1][j + 1] = array1[i] == array2[j] ? dp[i][j] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return dp[len1][len2];
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

    /**
     *
     */
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
}
// @lc code=end

