package org.luvx.leetcode.java.medium._31;
/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    /**
     * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]
     * [1,2,3,4],[1,2,4,3],[1,3,2,4],[1,3,4,2]
     * 从后往前找到第一个递增序列(取前者,如 1,2,4,3)，然后从后往前找到第一个比它大的数，然后交换
     */
    public void nextPermutation(int[] nums) {
        // 从后向前找到第一个nums[i-1] < num[i], 拿到 i-1 的值, 即pivot
        int pivot = indexOfLastPeak(nums) - 1;
        if (pivot != -1) {
            // 从后向前找到第一个大于nums[pivot]的位置, 然后交换值
            int nextPrefix = lastIndexOfGreater(nums, nums[pivot]);
            swap(nums, pivot, nextPrefix);
        }
        // 逆转顺序, 把降序变为升序
        int left = pivot + 1, right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    private int indexOfLastPeak(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    private int lastIndexOfGreater(int[] nums, int threshold) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > threshold) {
                return i;
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3};
        new Solution().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
// @lc code=end

