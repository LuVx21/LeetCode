package org.luvx.leetcode.java.medium._215;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
// @lc code=start
class Solution {
    /**
     * 数组中第 K 大的元素
     * 1. 最大堆
     * 2. 快排
     * <pre>
     *     [3,2,1,5,6,4]-2 -> 5
     *     [3,2,3,1,2,4,5,5,6]-4 -> 4
     * </pre>
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= nums[right]) {
                swap(nums, pivot++, j);
            }
        }
        swap(nums, pivot, right);

        int count = right - pivot + 1;
        if (count == k) {
            return nums[pivot];
        }
        if (count > k) {
            return quickSelect(nums, pivot + 1, right, k);
        }
        return quickSelect(nums, left, pivot - 1, k - count);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kthLargest = exec.findKthLargest(array, 4);
        System.out.println(kthLargest);
    }
}
// @lc code=end

