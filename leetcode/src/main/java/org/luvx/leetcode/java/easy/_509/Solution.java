package org.luvx.leetcode.java.easy._509;
/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    /**
     * 0 <= n <= 30
     */
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0, b = 1, data = 0;
        for (int i = 0; i < n - 1; i++) {
            data = a + b;
            a = b;
            b = data;
        }
        return data;

        // 递归 不用考虑
        // return fib1(n - 1) + fib1(n - 2);
    }

    public int fib0(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
// @lc code=end

