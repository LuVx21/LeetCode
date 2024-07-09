package org.luvx.leetcode.java.medium._453;
/*
 * @lc app=leetcode.cn id=453 lang=java
 *
 * [453] 最小操作次数使数组元素相等
 */

// @lc code=start
class Solution {
    /**
     * 比下面的快, 为什么
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }

        int count = 0;
        for (int num : nums) {
            count += num - min;
        }

        return count;
    }

    public int minMoves0(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        long min = nums[0], sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, num);
        }
        // 数组所有元素的和 - 最小的元素 * 数组长度
        return (int) (sum - min * nums.length);
    }
}
// @lc code=end
