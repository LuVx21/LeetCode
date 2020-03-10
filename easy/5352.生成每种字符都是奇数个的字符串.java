/*
 * @lc app=leetcode.cn id=5352 lang=java
 *
 * [5352] 生成每种字符都是奇数个的字符串
 */

// @lc code=start
class Solution {
    public String generateTheString(int n) {
        if (n == 1) {
            return "a";
        }
        char[] array = new char[n];
        array[0] = 'a';
        if ((n & 1) == 1) {
            array[1] = 'b';
            for (int i = 2; i < n; i++) {
                array[i] = 'c';
            }
        } else {
            for (int i = 1; i < n; i++) {
                array[i] = 'c';
            }
        }

        return String.valueOf(array);
    }
}
// @lc code=end

