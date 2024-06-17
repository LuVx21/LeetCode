package org.luvx.leetcode.java.easy._1342;
/*
 * @lc app=leetcode.cn id=1342 lang=java
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
class Solution {
    public int numberOfSteps(int num) {
        // 最简单的
        // return Integer.toBinaryString(num).length() - 1 + Integer.bitCount(num);

        int cnt = 0;
        while (num != 0) {
            num = (num % 2 == 0) ? num / 2 : num - 1;
            cnt++;
        }
        return cnt;
    }
}
// @lc code=end
