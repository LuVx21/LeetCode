package org.luvx.leetcode.java.medium._162;
/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    /**
     *
     */
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int last = nums.length - 1;
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[last] > nums[last - 1]) {
            return last;
        }

        int start = 1, end = last - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int left = nums[mid - 1], v = nums[mid], right = nums[mid + 1];
            if (left < v && v > right) {
                return mid;
            } else if (v < left) {
                end = mid - 1;
            } else if (v < right) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
// @lc code=end

