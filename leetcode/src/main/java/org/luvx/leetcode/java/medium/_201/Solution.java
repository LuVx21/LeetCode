package org.luvx.leetcode.java.medium._201;
/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start
class Solution {
    /**
     * 本质是找二进制的公共后缀
     */
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right &= right - 1;
        }
        return right;
    }

    /**
     * 容易理解
     */
    public int rangeBitwiseAnd1(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            ++shift;
        }
        return left << shift;
    }
}
// @lc code=end
