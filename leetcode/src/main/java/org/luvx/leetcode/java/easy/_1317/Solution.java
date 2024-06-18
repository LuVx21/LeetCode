package org.luvx.leetcode.java.easy._1317;
/*
 * @lc app=leetcode.cn id=1317 lang=java
 *
 * [1317] 将整数转换为两个无零整数的和
 */

// @lc code=start
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            int ii = n - i;
            if (contain(i) || contain(ii)) {
                continue;
            }
            return new int[]{i, ii};
        }

        return new int[]{0, n};
    }

    boolean contain(int n) {
        int nn = n;
        while (nn >= 10) {
            if (nn % 10 == 0) {
                return true;
            }
            nn /= 10;
        }
        return false;
    }
}
// @lc code=end

