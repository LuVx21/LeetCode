package org.luvx.leetcode.java.easy._1304;

// @lc code=start
/*
 * @lc app=leetcode.cn id=1304 lang=java
 *
 * [1304] 和为零的N个唯一整数
 */
class Solution {
    public int[] sumZero(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n - 1; i += 2) {
            array[i] = i + 1;
            array[i + 1] = -(i + 1);
        }
        return array;
    }
}
// @lc code=end

