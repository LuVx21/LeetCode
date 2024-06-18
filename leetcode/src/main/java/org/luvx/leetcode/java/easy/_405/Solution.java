package org.luvx.leetcode.java.easy._405;
/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    final char[] digits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    /**
     * {@link org.luvx.leetcode.java.easy._504.Solution#convertToBase7(int)}
     */
    public String toHex0(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(digits[num & 15]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        byte[] buf = new byte[8];
        int index = 0;
        while (num != 0) {
            buf[index++] = (byte) digits[num & 15];
            num >>>= 4;
        }

        byte[] bytes = new byte[index];
        for (int i = buf.length - 1, k = 0; i >= 0; i--) {
            byte b = buf[i];
            if (b == 0) {
                continue;
            }
            bytes[k++] = b;
        }
        return new String(bytes);
    }
}
// @lc code=end
