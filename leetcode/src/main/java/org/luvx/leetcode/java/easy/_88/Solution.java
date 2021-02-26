package org.luvx.leetcode.java.easy._88;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    /**
     * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * <p>
     * 3,4,5,6,7,0,0,0,0  1,2,8,9
     * ↓
     * 1,2,3,4,5,6,7,8,9
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mi = m - 1, ni = n - 1, mni = m + n - 1;
        while (mi >= 0 && ni >= 0) {
            nums1[mni--] = nums2[ni] > nums1[mi] ? nums2[ni--] : nums1[mi--];
        }
        // nums2中元素可能未完全移入 nums1 中
        System.arraycopy(nums2, 0, nums1, 0, ni + 1);
        // while (ni >= 0) {
        //     nums1[mni--] = nums2[ni--];
        // }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                System.arraycopy(nums1, i, nums1, i + 1, m - i);
                nums1[i++] = nums2[j++];
                m++;
            }
        }
        if (i == m) {
            System.arraycopy(nums2, j, nums1, i, n - j);
        }
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {0, 5, 6};
        exec.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
// @lc code=end
