/*
 * @lc app=leetcode.cn id=1323 lang=java
 *
 * [1323] 6 和 9 组成的最大数字
 */

// @lc code=start
class Solution {
    public int maximum69Number (int num) {
        int temp = num, index = -1;

        for (int i = 0; i < 4 || temp > 0; i++) {
            int v = temp % 10;
            if (v == 6) {
                index = i;
            }
            temp = temp / 10;
        }
        int plus = index == -1 ?
                0 : (3 * (int) Math.pow(10, index));
        return num + plus;
    }
}
// @lc code=end

