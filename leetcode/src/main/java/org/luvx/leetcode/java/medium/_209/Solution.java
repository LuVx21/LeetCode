package org.luvx.leetcode.java.medium._209;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */
// @lc code=start
class Solution {
    /**
     * <pre>
     * 2 3 1 2 4 3
     * ↑     ↑
     * </pre>
     * <p>
     * 前缀和 + 二分查找 O(nlogN)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int r = Integer.MAX_VALUE;
        // 存储前缀和, 下标i表示前i个元素的和
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int bound = Arrays.binarySearch(sums, target + sums[i]);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= nums.length) {
                r = Math.min(r, bound - i);
            }
        }
        return r == Integer.MAX_VALUE ? 0 : r;
    }

    /**
     * 滑动窗口
     */
    public int minSubArrayLen0(int target, int[] nums) {
        int r = nums.length + 1, left = 0, sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                r = Math.min(r, right - left + 1);
                sum -= nums[left++];
            }
        }
        return r > nums.length ? 0 : r;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int left = 0, right = 0, sum = 0, r = Integer.MAX_VALUE;
        while (right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right++];
                if (sum >= target) {
                    r = Math.min(r, right - left);
                }
            }

            while (left < right && sum >= target) {
                sum -= nums[left++];
                if (sum >= target) {
                    r = Math.min(r, right - left);
                }
            }
        }
        return r == Integer.MAX_VALUE ? 0 : r;
    }
}
// @lc code=end
