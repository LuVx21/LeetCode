package org.luvx.question;

import java.util.Arrays;

public class Q88 {
    /**
     * leetcode-88 扩展
     * 合并三个有序数组
     * 未完待续
     */
    public void merge(int[] nums1, int m, int[] nums2, int[] nums3) {
        int i1 = m - 1, i2 = nums2.length - 1, i3 = nums3.length - 1;
        int j = nums1.length - 1;
        while (i1 >= 0 && i2 >= 0 && i3 >= 0) {
            if (nums2[i2] > nums1[i1] && nums2[i2] > nums3[i3]) {
                nums1[j--] = nums2[i2--];
            }
        }
    }

    public static void main(String[] args) {
        Q88 exec = new Q88();
        int[] nums1 = {1, 2, 3, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        int[] nums3 = {7, 8, 9};
        exec.merge(nums1, 3, nums2, nums3);
        System.out.println(Arrays.toString(nums1));
    }
}
