package org.luvx.leetcode.java.medium._153;
/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

import java.util.List;

// @lc code=start
class Solution {
    /**
     * 4, 5, 6, 7, 0, 1, 2
     */
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        List.of(
                new int[] {1, 2},
                new int[] {11, 13, 15, 17},
                new int[] {3, 4, 5, 1, 2},
                new int[] {4, 5, 6, 7, 0, 1, 2}
        ).forEach(array ->
                System.out.println(exec.findMin(array))
        );
    }
}
// @lc code=end

