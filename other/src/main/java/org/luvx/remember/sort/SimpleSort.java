package org.luvx.remember.sort;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 简单选择排序
 *
 * @author Ren, Xie
 */
public class SimpleSort {
    public static void sort5(int[] array) {
        final int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (array[k] > array[j]) {
                    k = j;
                }
            }
            if (k != i) {
                ArrayUtils.swap(array, i, k);
            }
        }
    }
}
