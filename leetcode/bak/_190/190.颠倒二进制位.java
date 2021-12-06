/*
 * @lc app=leetcode.cn id=190 lang=java
 *
 * [190] 颠倒二进制位
 */

// @lc code=start
public class Solution {
    /**
     * d左移 n右移
     *
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int d = 0;
        for (int i = 0; i < 32; i++) {
            d = (d << 1) | (n & 1);
            n = n >> 1;
        }
        return d;
    }
}
// @lc code=end

