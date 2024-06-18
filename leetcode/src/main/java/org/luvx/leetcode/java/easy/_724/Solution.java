package org.luvx.leetcode.java.easy._724;
/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    /**
     * 和No.1991相同
     * {@link org.luvx.leetcode.java.easy._1991.Solution#findMiddleIndex(int[])}
     */
    public int pivotIndex(int[] nums) {
        int lSum = 0, rSum = 0;
        for (int num : nums) {
            rSum += num;
        }

        for (int i = 0; i < nums.length; i++) {
            rSum -= nums[i];
            if (lSum == rSum) {
                return i;
            }
            lSum += nums[i];
        }

        return -1;
    }
}
// @lc code=end
