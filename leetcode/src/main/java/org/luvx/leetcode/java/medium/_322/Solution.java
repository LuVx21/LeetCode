package org.luvx.leetcode.java.medium._322;
/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    /**
     * 迭代: [1,2,5],11
     * [1,3,97,98],100
     * <p>
     * 完全背包问题:
     * 硬币面值对应石头的价值,
     * 正数amount对应装入背包中的总价值,
     * 求最少硬币数对应求石头的最小重量(单个石头重量对应都为1)
     * <p>
     * 大数组dp: 每个槽位均为大小为i的背包, 值为此背包的硬币数量
     * <p>
     * i: 既是数组的下标也是一个整钱金额
     * cost: 组成i金额所需硬币最少数量, -1则代表无法组成i金额
     * 内层循环是为了找到组成i的最少硬币数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        // dp[j] = 凑成金额j(背包大小)所需最少硬币数量
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int cost = -1;
            for (int coin : coins) {
                int m = i - coin;
                if (coin <= i && dp[m] != -1) {
                    int temp = dp[m] + 1;
                    cost = cost < 0 ? temp : Math.min(temp, cost);
                }
            }
            dp[i] = cost;
        }
        return dp[amount];
    }

    /**
     * 递归
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return backtrack(coins, amount, new int[amount]);
    }

    private int backtrack(int[] coins, int amount, int[] count) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = backtrack(coins, amount - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}
// @lc code=end
