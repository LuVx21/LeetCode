/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */
class Solution {
    /**
     * 给定两个二进制字符串, 返回他们的和(用二进制表示).
     * 输入为非空字符串且只包含数字1和0.
     *
     * <pre>
     *    10 1011
     * +  10 1101
     * = 101 1000
     * +  10 1101
     * =1000 0101
     * </pre>
     * <p>
     * 二进制进位时, 进位数只有0和1
     */
    public static String addBinary(String a, String b) {
        int aLen = a.length() - 1, bLen = b.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();
        while (aLen >= 0 || bLen >= 0) {
            int sum = carry;
            if (aLen >= 0) {
                sum += a.charAt(aLen--) - '0';
            }
            if (bLen >= 0) {
                sum += b.charAt(bLen--) - '0';
            }
            result.append(sum % 2);
            carry = sum >= 2 ? 1 : 0;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}

