/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber(String s) {
        if (s == null) {
            return -1;
        }
        int result = 0;
        for (char c : s.toCharArray()) {
            result *= 26;
            result += c - 'A' + 1;
        }
        return result;
    }

    public int titleToNumber0(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            int index = chars.length - i - 1;
            char c = chars[i];
            int i1 = c - 64;
            result += i1 * (Math.pow(26, index));
        }
        return result;
    }
}
// @lc code=end

