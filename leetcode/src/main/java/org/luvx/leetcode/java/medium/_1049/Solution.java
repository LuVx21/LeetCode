package org.luvx.leetcode.java.medium._1049;
/*
 * @lc app=leetcode.cn id=1049 lang=java
 *
 * [1049] 最后一块石头的重量 II
 */

// @lc code=start
class Solution {
    /**
     * 2,7,4,1,8,1 -> 找到一个数组(长度和石头的长度一样)flag, 其内部元素只能为1或-1
     * 循环 石头[i] * flag[i] 求和 其绝对值最小, 那么这个flag便是最终答案
     * <pre>
     *      2, 7,4, 1,8,1    => sum=23
     *     -1,-1,1,-1,1,-1   => 8+4  -(2+7+1+1)
     *     -2-7+4-1+8-1 => 1
     * 为什么能转为01背包问题:
     * 正数组+负数组=sum(数组总和)
     * 正数组-负数组=min(最小重量)
     * min(最小重量) = sum - 2*正数组
     * min尽可能的小, 那么正数组尽可能接近`sum/2`
     * </pre>
     * 关联: No.494
     */
    public int lastStoneWeightII(int[] ss) {
        int sum = 0;
        for (int i : ss) {
            sum += i;
        }

        // 01背包问题的背包容量, 石头的重量和价值都是石头元素本身
        int t = sum / 2;
        // dp[j] = 不大于j的最大和
        int[] dp = new int[t + 1];
        for (int num : ss) {
            for (int j = t; j >= num; j--) {
                // 不计入num和计入num, 取大值
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }

        // 添加负号: dp[t], sum-添加负号: 添加正号
        int i = sum - dp[t];
        // 添加正号-添加符号 => 剩下的
        return Math.abs(i - dp[t]);
    }

    public int lastStoneWeightII0(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }

        // dp[][] = x
        boolean[][] dp = new boolean[sum / 2 + 1][stones.length + 1];
        for (int i = 0; i <= stones.length; i++) {
            dp[0][i] = true;
        }

        int S2 = 0;
        for (int i = 1; i <= stones.length; i++) {
            for (int s = 1; s <= sum / 2; s++) {
                if (dp[s][i - 1] || (s >= stones[i - 1] && dp[s - stones[i - 1]][i - 1])) {
                    dp[s][i] = true;
                    S2 = Math.max(s, S2);
                }
            }
        }
        return sum - 2 * S2;
    }
}
// @lc code=end
