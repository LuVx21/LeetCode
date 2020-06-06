/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */
class Solution {
    /**
     * 迭代: [1,2,5],11
     * [1,3,97,98],100
     * <pre>
     *   97 98 99 100
     *   1  1  2
     * </pre>
     * <p>
     * 完全背包问题
     * 大数组array: 每个槽位均为大小为i的背包, 值为此背包的硬币数量
     * <p>
     * i: 既是数组的下标也是一个整钱金额
     * cost: 组成i金额所需硬币最少数量, -1则代表无法组成i金额
     * 内层循环是为了找到组成i的最少硬币数
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] array = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int cost = -1;
            for (int coin : coins) {
                if (coin <= i && array[i - coin] != -1) {
                    int temp = array[i - coin] + 1;
                    cost = cost < 0 ? temp : Math.min(temp, cost);
                }
            }
            array[i] = cost;
        }
        return array[amount];
    }

    /**
     * 递归
     */
    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);
    }

    private int helper(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) return count[amount - 1];
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = helper(coins, amount - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount - 1];
    }
}
