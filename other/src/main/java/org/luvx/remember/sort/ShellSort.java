package org.luvx.remember.sort;

public class ShellSort {
    /**
     * 希尔排序
     */
    public static void shellSort(int[] array) {
        int len = array.length;
        // 分割的组数
        int groups = 2, nums = len / groups;
        while (nums >= 1) {
            // 循环的次数和组数相同
            for (int i = 0; i < groups; i++) {
                for (int j = i + nums; j < len; j += nums) {
                    int temp = array[j];
                    int k = j - nums;
                    // 右移数据用循环
                    while (k >= i && array[k] > temp) {
                        array[k + nums] = array[k];
                        k -= nums;
                    }
                    // 插入数据
                    array[k + nums] = temp;
                }
            }
            nums = nums / 2;
        }
    }
}
