package org.luvx.remember.sort;

import org.apache.commons.lang3.ArrayUtils;

public class SelectSort {
    /**
     * 直接选择排序
     */
    public static void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int unSortStart = i;
            for (int j = i + 1; j < len; j++) {
                if (array[j] < array[unSortStart]) {
                    unSortStart = j;
                }
            }
            if (unSortStart != i) {
                ArrayUtils.swap(array, i, unSortStart);
            }
        }
    }
}
