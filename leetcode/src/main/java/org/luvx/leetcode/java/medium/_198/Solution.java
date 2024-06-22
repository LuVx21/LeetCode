package org.luvx.leetcode.java.medium._198;
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     * 针对一个房间, 有两个选项: 偷或不偷
     * 偷:  最近的可偷在下下个, 也有两个选项
     * 不偷: 最近的可偷在下个或下下个, 每个同样两个选项
     * </pre>
     * 2 7 9 3 1 => 12
     * 2 1 1 2   => 4
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        // region 状态压缩优化
        int last = nums[nums.length - 1];
        int lastSecond = Math.max(nums[nums.length - 2], last);
        for (int i = nums.length - 3; i >= 0; i--) {
            var t = lastSecond;
            lastSecond = Math.max(lastSecond, nums[i] + last);
            last = t;
        }
        return lastSecond;
        // endregion

        // region 动态规划
        // 从第i个房屋开始向右偷的最高金额
        // int[] dp = new int[nums.length];
        // dp[nums.length - 1] = nums[nums.length - 1];
        // dp[nums.length - 2] = Math.max(nums[nums.length - 2], nums[nums.length - 1]);
        // for (int i = nums.length - 3; i >= 0; i--) {
        //     int ii = nums[i] + dp[i + 2];
        //     int jj = dp[i + 1];
        //     dp[i] = Math.max(ii, jj);
        // }
        // return dp[0];
        // endregion

        // region 缓存(4个房屋, 函数调用了9次)
        // int[] cache = new int[nums.length];
        // Arrays.fill(cache, -1);
        // return rob1(nums, 0, cache);
        // endregion

        // region 递归(4个房屋, 函数调用了15次)
        // return rob0(nums, 0);
        // endregion
    }

    private int rob1(int[] nums, int start, int[] cache) {
        if (start >= nums.length) {
            return 0;
        }
        if (cache[start] != -1) {
            return cache[start];
        }

        int i = nums[start] + rob1(nums, start + 2, cache);
        int j = rob1(nums, start + 1, cache);
        return cache[start] = Math.max(i, j);
    }

    /**
     * 递归, 超时
     */
    private int rob0(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }

        int i = nums[start] + rob0(nums, start + 2);
        int j = rob0(nums, start + 1);
        return Math.max(i, j);
    }
}
// @lc code=end

