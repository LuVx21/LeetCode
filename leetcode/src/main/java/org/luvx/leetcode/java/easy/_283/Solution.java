package org.luvx.leetcode.java.easy._283;
/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    /**
     * 0,1,0,3,12
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if (num != 0) {
                nums[i++] = num;
            }
        }
        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }

    public void moveZeroes0(int[] nums) {
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
        }
        if (zeroCount == 0) {
            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if (num != 0) {
                nums[i++] = num;
            }
        }
        for (int j = nums.length - zeroCount; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
// @lc code=end
