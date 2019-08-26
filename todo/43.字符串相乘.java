/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */
class Solution {
    /**
     * <pre>
     *   123
     *   456
     * = 49200 + 6150 + 738
     * = 56088
     * </pre>
     * <p>
     * 不以零开头，除非是数字 0 本身, 包含数字 0-9
     */
    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        StringBuilder sum = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int a = Integer.valueOf(num2.charAt(i) + "");
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = a * Integer.valueOf(num1.charAt(j) + "") + carry;
                carry = b / 10;
                b = b % 10;
                sb.insert(0, b);
                if (j == 0 && carry != 0) {
                    sb.insert(0, carry);
                }
            }
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                sb.append("0");
            }
            sum = plus(sum, sb);
        }
        return sum.toString();
    }

    /**
     * <pre>
     *   12222
     *    9999
     * = 22221
     *
     *     94497789
     *    987654312
     * = 1082152101
     * </pre>
     */
    private StringBuilder plus(StringBuilder num1, StringBuilder num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            int ii = 0, jj = 0;
            if (i >= 0) {
                ii = Integer.valueOf(num1.charAt(i--) + "");
            }
            if (j >= 0) {
                jj = Integer.valueOf(num2.charAt(j--) + "");
            }
            int kk = ii + jj + carry;
            carry = kk / 10;
            kk = kk % 10;
            sum.insert(0, kk);
        }
        if (carry != 0) {
            sum.insert(0, carry);
        }
        return sum;
    }
}

