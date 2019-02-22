/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 *
 * https://leetcode-cn.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (31.19%)
 * Total Accepted:    75.5K
 * Total Submissions: 241.9K
 * Testcase Example:  '123'
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123
 * 输出: 321
 * 
 * 
 * 示例 2:
 * 
 * 输入: -123
 * 输出: -321
 * 
 * 
 * 示例 3:
 * 
 * 输入: 120
 * 输出: 21
 * 
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 */
/**
-2^31=-2147483648 -> 2^31-1=2147483647
[-2147483648,2147483647]
 */
class Q7 {
    public int reverse(int x) {
        String v = "";
        if (x < 0) {
            v = Integer.toString(x).substring(1);
        } else {
            v = Integer.toString(x);
        }

        v = (x < 0 ? "-" : "") + new StringBuffer(v).reverse().toString();

        int a = 0;
        try {
            a = Integer.valueOf(v);
        } catch (NumberFormatException e) {
            a = 0;
        }

        return a;
    }
}
