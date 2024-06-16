package org.luvx.leetcode.java.easy._191;

/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
class Solution {
    public int hammingWeight(int n) {
        int d = 0;
        while (n != 0) {
            d += (n & 1);
            n >>>= 1;
        }
        return d;
    }

    /**
     * https://leetcode.cn/problems/number-of-1-bits/solutions/1623246/by-stormsunshine-6h0z/
     */
    public int hammingWeight1(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = (n + (n >>> 8)) & 0x00ff00ff;
        n = (n + (n >>> 16)) & 0x0000ffff;
        return n;
    }
}
// @lc code=end

