package org.luvx.leetcode.java.easy._461;
/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance1(int x, int y) {
        int cnt = 0;
        while (x > 0 || y > 0) {
            if ((x & 1) != (y & 1)) {
                cnt++;
            }
            if (x > 0) {
                x >>= 1;
            }
            if (y > 0) {
                y >>= 1;
            }
        }
        return cnt;
    }
}
// @lc code=end

