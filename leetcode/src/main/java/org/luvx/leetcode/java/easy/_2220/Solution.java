package org.luvx.leetcode.java.easy._2220;
/*
 * @lc app=leetcode.cn id=2220 lang=java
 *
 * [2220] 转换数字的最少位翻转次数
 */

// @lc code=start
class Solution {
    /**
     * 10() -> 7(111)
     * 3(011) -> 4(100)
     * 参考: No.191
     */
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
// @lc code=end
