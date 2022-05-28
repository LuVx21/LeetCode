package org.luvx.leetcode.java.medium._34;
/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start

class Solution {
    /**
     * 5,7,7,8,8,10 - 8 -> [3,4]
     * 5,7,7,8,8,9,10 - 9 -> [5,5]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] != target) {
            return result;
        }
        result[0] = start;

        end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2 + 1;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        result[1] = end;
        return result;
    }
}
// @lc code=end

