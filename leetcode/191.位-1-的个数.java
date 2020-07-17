/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int d = 0;
        for (int i = 0; i < 32; i++) {
            d += (n & 1);
            n = n >> 1;
        }
        return d;
    }
}
// @lc code=end

