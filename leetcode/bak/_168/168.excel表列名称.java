/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int n) {
        // return n == 0 ? "" : convertToTitle(--n / 26) + (char) ('A' + (n % 26));
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        do {
            int b = n % 26;
            sb.insert(0, (char) (64 + (b == 0 ? 26 : b)));
            n = (n - 1) / 26;
        } while (n > 0);

        return sb.toString();
    }
}
// @lc code=end

