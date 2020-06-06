package org.luvx;

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 *
 * https://leetcode-cn.com/problems/merge-sorted-array/description/
 *
 * algorithms
 * Easy (42.16%)
 * Total Accepted:    24.6K
 * Total Submissions: 58.3K
 * Testcase Example:  '[1,2,3,0,0,0]\n3\n[2,5,6]\n3'
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
class Q88 {
    // 122300 256
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {0, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                for (int k = m - 1; k >= i; k--) {
                    nums1[k + 1] = nums1[k];
                }
                nums1[i++] = nums2[j++];
                m++;
            }
        }

        if (i == m) {
            System.arraycopy(nums2, j, nums1, i, n - j);
        }
        if (j == n - 1) {
            System.arraycopy(nums1, i, nums2, j, m - i);
        }

        System.out.println(Arrays.toString(nums1));
    }
}
