package org.luvx.leetcode.java.easy._1991;
/*
 * @lc app=leetcode.cn id=1991 lang=java
 *
 * [1991] 找到数组的中间位置
 */

// @lc code=start
class Solution {
    /**
     * 和No.724相同
     * {@link org.luvx.leetcode.java.easy._724.Solution#pivotIndex(int[])}
     */
    public int findMiddleIndex(int[] nums) {
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

