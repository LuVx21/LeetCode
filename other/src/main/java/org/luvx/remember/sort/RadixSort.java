package org.luvx.remember.sort;

import java.util.Arrays;

import com.google.common.primitives.Ints;

/**
 * 基数排序: 从个位数开始排序
 * 考虑负数的情况还可以参考： https://code.i-harness.com/zh-CN/q/e98fa9
 */
public class RadixSort {
    /**
     * 基数排序
     *
     * @param array 待排序数组
     */
    public static void sort(int[] array) {
        int max = Ints.max(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }

    /**
     * 相同位之间采用计数排序
     */
    private static void countSort(int[] array, int exp) {
        int length = array.length;
        int[] tempArray = new int[length];
        int[] countArray = new int[10];

        for (int num : array) {
            countArray[(num / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        // 为了稳定性而使用倒序
        for (int i = length - 1; i >= 0; i--) {
            int index = (array[i] / exp) % 10;
            tempArray[countArray[index] - 1] = array[i];
            countArray[index]--;
        }

        System.arraycopy(tempArray, 0, array, 0, length);
    }

    /**
     * 获得给定数字的指定位的数字
     *
     * @param num 原数字
     * @param i 位数, 0:个位 1:十位
     */
    private static int getNumIn(int num, int i) {
        if (i > 9) {
            return 0;
        } else {
            int div = 1;
            for (; i > 0; i--) {
                div *= 10;
            }
            return (num / div) % 10;
        }

        // 或使用jdk
        // return (num / (int) Math.pow(10, i)) % 10;
    }

    public static void main(String[] args) {
        int[] array = {103, 2, 55, 30, 43};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
