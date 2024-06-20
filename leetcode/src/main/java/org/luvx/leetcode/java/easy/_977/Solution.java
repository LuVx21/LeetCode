package org.luvx.leetcode.java.easy._977;
/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    /**
     * -4,-1,-1,0,3,10
     */
    public int[] sortedSquares(int[] nums) {
        int[] r = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            int i = nums[left] * nums[left];
            int i1 = nums[right] * nums[right];
            if (i >= i1) {
                r[index--] = i;
                left++;
            } else {
                right--;
                r[index--] = i1;
            }
        }

        return r;
    }
}
// @lc code=end

