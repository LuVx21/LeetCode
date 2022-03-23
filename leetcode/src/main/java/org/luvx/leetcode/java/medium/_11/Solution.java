package org.luvx.leetcode.java.medium._11;
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int water = 0, left = 0, right = height.length - 1;
        while (left < right) {
            int w = Math.min(height[left], height[right]) * (right - left);
            water = Math.max(water, w);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] array = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(exec.maxArea(array));
    }
}
// @lc code=end

