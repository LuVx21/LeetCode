package org.luvx.leetcode.java.medium._503;
/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        var stack = new int[nums.length * 2];
        int si = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            stack[++si] = nums[i];
        }

        int[] r = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (si >= 0 && stack[si] <= nums[i]) {
                si--;
            }
            r[i] = si >= 0 ? stack[si] : -1;
            stack[++si] = nums[i];
        }

        return r;
    }

    /**
     * 1, 2, 3, 4, 3, 2
     * 逆序
     */
    public int[] nextGreaterElements1(int[] nums) {
        int[] r = new int[nums.length];
        var stack = new int[nums.length * 2];
        int si = -1;

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            var ii = i % nums.length;
            while (si >= 0 && stack[si] <= nums[ii]) {
                si--;
            }
            r[ii] = si >= 0 ? stack[si] : -1;
            stack[++si] = nums[ii];
        }

        return r;
    }

    /**
     * 1, 2, 3, 4, 3, 2  | 1, 2, 3, 4, 3, 2
     * 正序
     */
    public int[] nextGreaterElements0(int[] nums) {
        int[] r = new int[nums.length];
        // 元素: index-val
        var stack = new int[nums.length * 2][2];
        int si = -1;

        for (int i = 0; i < 2 * nums.length; i++) {
            boolean over = i >= nums.length;
            var ii = i % nums.length;
            while (si >= 0 && stack[si][1] < nums[ii]) {
                int i1 = stack[si--][0];
                r[i1] = nums[ii];
            }
            stack[++si] = new int[]{ii, nums[ii]};
            if (!over) {
                r[ii] = -1;
            }
        }
        return r;
    }
}
// @lc code=end
