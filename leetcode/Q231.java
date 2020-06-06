/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 *
 * https://leetcode-cn.com/problems/power-of-two/description/
 *
 * algorithms
 * Easy (43.60%)
 * Total Accepted:    11K
 * Total Submissions: 25.3K
 * Testcase Example:  '1'
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 
 * 示例 2:
 * 
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 
 * 示例 3:
 * 
 * 输入: 218
 * 输出: false
 * 
 */
class Q231 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        char[] array = Integer.toBinaryString(n).toCharArray();
        int count = 0;
        for (char c : array) {
            if (c == '1') {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfTwo1(int n) {
        return (n > 0) && ((n & n - 1) == 0);
    }

}
