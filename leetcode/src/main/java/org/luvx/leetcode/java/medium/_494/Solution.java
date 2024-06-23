package org.luvx.leetcode.java.medium._494;
/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    /**
     * #动态规划
     * #0-1背包
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // target = 正符号元素和 - 负符号元素和 = (sum - 负符号元素和) - 负符号元素和
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }

        // 由此`nums添加符号目标和为target`的问题转化为,`nums不添加符号和为neg`的问题
        // 负号元素的和
        int neg = diff / 2;

        // region 方式1的优化
        // dp[目标和j] = 组合数量
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = neg; j >= num; j--) {
                // 不保留num的组合数+保留num的组合数
                dp[j] += dp[j - num];
            }
        }
        return dp[neg];
        // endregion

        // region 方式1
        // dp[i个元素][目标和j] = 组合数量
        // int[][] dp = new int[nums.length + 1][neg + 1];
        // // 0个元素,目标和为0 => 1个组合; 0个元素,目标和>0 => 0个组合
        // dp[0][0] = 1;
        // for (int i = 1; i <= nums.length; i++) {
        //     int num = nums[i - 1];
        //     for (int j = 0; j <= neg; j++) {
        //         // 不保留num用于计算的组合数
        //         dp[i][j] = dp[i - 1][j];
        //         if (num <= j) {
        //             // 保留num用于计算的组合数
        //             dp[i][j] += dp[i - 1][j - num];
        //         }
        //     }
        // }
        // return dp[nums.length][neg];
        // endregion
    }
}
// @lc code=end
