package org.luvx.leetcode.java.medium._96;
/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {
    /**
     * #动态规划
     * #卡特兰数
     * 1 1
     * 2 2
     * 3 5
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    /**
     * 数学计算
     */
    public int numTrees1(int n) {
        long r = 1;
        for (int i = 0; i < n; i++) {
            r = r * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) r;
    }

}
// @lc code=end
