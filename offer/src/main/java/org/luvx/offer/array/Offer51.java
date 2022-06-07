package org.luvx.offer.array;

import org.apache.commons.lang3.ArrayUtils;

public class Offer51 {
    /**
     * 题目：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，
     * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
     *
     * @param array 数组
     */
    public int duplicate(int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            return -1;
        }
        for (int i : array) {
            if (i < 0 || i >= array.length) {
                return -1;
            }
        }

        for (int i = 0; i < array.length; i++) {
            // 当number[i]与i不相同的时候一直交换
            while (array[i] != i) {
                // 如果i位置与number[i]位置的数字相同，说明有重复数字
                if (array[i] == array[array[i]]) {
                    return array[i];
                }
                // 如果不同就交换
                ArrayUtils.swap(array, i, array[i]);
            }
        }
        return -1;
    }
}
