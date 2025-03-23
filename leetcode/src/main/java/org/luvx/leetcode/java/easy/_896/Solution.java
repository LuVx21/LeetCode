package org.luvx.leetcode.java.easy._896;

/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean up = true, down = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                up = false;
            }
            if (nums[i] < nums[i + 1]) {
                down = false;
            }
            // 都为false
            if (!up && !down) {
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic1(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean isIncrease = true;
        int k = 0;
        for (; k < nums.length - 1; k++) {
            if (nums[k] != nums[k + 1]) {
                isIncrease = nums[k] < nums[k + 1];
                break;
            }
            if (k == nums.length - 2) {
                return true;
            }
        }

        int pre = nums[k + 1];
        for (int i = k + 2; i < nums.length; i++) {
            boolean e = pre == nums[i];
            if (e || isIncrease == (pre < nums[i])) {
                pre = nums[i];
                continue;
            }
            return false;
        }

        return true;
    }
}
// @lc code=end
