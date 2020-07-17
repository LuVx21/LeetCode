/*
 * @lc app=leetcode.cn id=172 lang=java
 *
 * [172] 阶乘后的零
 */

// @lc code=start
class Solution {
    /**
     * O(log n)
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int cnt = 0;
        for (; n > 0; ) {
            n /= 5;
            cnt += n;
        }
        return cnt;
    }
}
// @lc code=end

