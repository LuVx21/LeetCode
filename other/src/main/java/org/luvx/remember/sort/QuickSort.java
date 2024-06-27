package org.luvx.remember.sort;

import java.util.Random;

import static org.apache.commons.lang3.ArrayUtils.swap;

public class QuickSort {

    /**
     * 快速排序
     * pivot的获取: array[left], array[right], array[left+(right-left)/2], array[left~right随机], array[三数取中]
     *
     * @param array 排序数组
     * @param left  排序范围起点
     * @param right 排序范围终点
     */
    public static void sort(int[] array, int left, int right) {
        // 此处right-left<=2, 直接交换下即可, 不比再调用函数
        // 此处right-left<=?, 考虑不再使用快排, 而使用插入排序(近乎有序时,复杂度能接近O(n))
        if (right <= left) {
            return;// 只有0或1个记录,不需排序
        }
        int pivot = partition2(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    /**
     * 三分区 快排
     */
    public static void quickSort3Way(int[] array, int left, int right) {
        if (right <= left) {
            return;
        }

        // 随机选择要做比较的值
        swap(array, left, left + new Random().nextInt(right - left + 1));

        int pivot = array[left];
        int i = left + 1;
        int lt = left, gt = right;
        while (i < gt + 1) {
            // 处理值小于基准值 合并到小于区
            if (array[i] < pivot) {
                swap(array, i, lt + 1);
                lt++;
                i++;
            } else if (array[i] > pivot) {
                // 处理值大于基准值 合并到大于区
                swap(array, i, gt);
                gt--;
            } else {
                // 处理值等于基准值 合并到等于区
                i++;
            }
        }
        // 最终调整
        swap(array, left, lt);
        // 获取下一次处理的左右边界 小于区右边界lt-1 大于区左边界gt
        quickSort3Way(array, left, lt - 1);
        quickSort3Way(array, gt, right);
    }

    // 三数取中
    private static int getMid0(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        if (array[left] < array[mid]) {
            swap(array, mid, left);
        }
        // 此时array[mid] <= array[left] <= array[right]
        return array[left];
    }

    // 分割策略2:在策略1基础上减少了同一位置的赋值操作
    public static int partition2(int[] array, int left, int right) {
        // 极端情况下, 相当于没有以此为轴分成两部分
        // int pivot = array[left];
        // 三数取中
        int pivot = getMid0(array, left, right);
        while (left < right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            // 排除left < right, 此时array[right]<=pivot,所以移到左面
            if (left < right) {
                array[left] = array[right];
                left++;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // 排除left < right, 此时array[left]>pivot,所以移到右面
            if (left < right) {
                array[right] = array[left];
                right--;
            }
        }
        array[left] = pivot;
        return left;
    }

    // 分割策略3
    public static int partition3(int[] array, int start, int end) {
        int pivot = array[start], left = start, right = end;
        while (left <= right) {// 等号不可删除
            while (left <= right && array[left] <= pivot) {
                left++;
            }
            while (left <= right && array[right] > pivot) {
                right--;
            }

            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        swap(array, start, right);
        return right;
    }

    /**
     * 分割策略1
     */
    public static int partition1(int[] array, int left, int right) {
        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] > pivot) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }
}
