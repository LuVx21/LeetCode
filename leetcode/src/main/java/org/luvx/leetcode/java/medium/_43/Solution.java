package org.luvx.leetcode.java.medium._43;
/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     *   012   012
     *   123 * 456
     *    0 1 2 3 4 5
     *   [0,0,0,0,1,8]
     *   [0,0,0,1,6,8]
     *   [0,0,1,3,6,8]
     *   [0,0,1,4,8,8]
     *   [0,0,2,4,8,8]
     *   [0,1,0,4,8,8]
     *   [0,1,1,0,8,8]
     *   [0,1,6,0,8,8]
     *   [0,5,6,0,8,8]
     *
     *    456
     *    123
     * = 1368
     *   912
     * =10488
     *  456
     * =56088
     * </pre>
     * <p>
     * 模拟乘法竖式的过程
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int[] pos = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = p1 + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (sb.length() != 0 || p != 0) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        System.out.println(exec.multiply("123", "456"));
    }
}
// @lc code=end

