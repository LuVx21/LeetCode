package org.luvx.leetcode.java.easy._1356;
/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

import java.util.Arrays;

// @lc code=start
class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += Integer.bitCount(arr[i]) * 1_0001;
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 1_0001;
        }
        return arr;
    }
}
// @lc code=end
