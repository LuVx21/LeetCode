package org.luvx.remember.sort;

import java.util.Arrays;

public class InsertionSort {

    /**
     * 直接插入排序
     */
    public static void insertionSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    /**
     * 折半插入排序: 利用已排序部分的有序性进行二分查找,确定新元素的插入位置
     */
    public static void binInsertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int left = 0, right = i - 1;
            while (left <= right) {
                int middle = left + (right - left) / 2;
                if (array[middle] > temp) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            if (i > left) {
                System.arraycopy(array, left, array, left + 1, i - left);
            }
            array[left] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {43, 99, 38, 76, 65, 27, 17};
        // int[] arr = {1, 0, 4, 3, 6, 7, 2};
        // insertionSort(arr);
        binInsertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
