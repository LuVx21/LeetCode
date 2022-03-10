package org.luvx.leetcode.java.easy._35;
/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    /**
     * 1,3,5,6 - 4
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
// @lc code=end

