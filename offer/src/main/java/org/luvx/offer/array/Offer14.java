package org.luvx.offer.array;

import org.apache.commons.lang3.ArrayUtils;

public class Offer14 {

    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有奇数位于数组的前半部分，所有偶数位予数组的后半部分。
     *
     * @param arr 输入的数组
     */
    public static void reorderOddEven(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int start = 0, end = arr.length - 1;
        while (start < end) {
            while (start < end && arr[start] % 2 != 0) {
                start++;
            }
            while (start < end && arr[end] % 2 == 0) {
                end--;
            }

            ArrayUtils.swap(arr, start, end);
        }
    }
}
