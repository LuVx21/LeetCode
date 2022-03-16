package org.luvx.remember.sort;

import static org.apache.commons.lang3.ArrayUtils.swap;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 冒泡排序
 *
 * @author Ren, Xie
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * 外层循环控制遍历次数, 不用于定位元素
     *
     * @param array 排序数组
     */
    public static void sort0(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    /**
     * 优化1:当某一次遍历中一次交换都没有发生,
     * 则已经达到有序, 不必进行剩下的比较
     * 优化了左边已有序时的情形
     *
     * @param array 排序数组
     */
    public static void sort1(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            boolean isSorted = true;
            for (int j = 1; j < len - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 优化2:确定有序区边界
     * 优化右边已有序时的情形
     * 如:3,4,2,1,5,6,7,8
     *
     * @param array 排序数组
     */
    public static void sort2(int[] array) {
        int len = array.length;
        // 有序区起点, 无序区终点
        int sortStart = len, unSortEnd = len;
        for (int i = 0; i < len; i++) {
            boolean isSorted = true;
            for (int j = 1; j < unSortEnd; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    isSorted = false;
                    sortStart = j;
                }
            }
            unSortEnd = sortStart;
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序(定向冒泡排序)
     * 排序时是以双向在序列中进行排序
     *
     * @param array 排序数组
     */
    public static void cocktailSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
            for (int j = len - 1 - (i + 1); j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        //        int[] array = {3, 4, 2, 1, 5, 6, 7, 8};
        int[] array = {5, 2, 3, 1};
        sort2(array);
        System.out.println(ArrayUtils.toString(array));
    }
}
