/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */
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
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    /**
     * <pre>
     *   123
     *   456
     * = 49200 + 6150 + 738
     * = 56088
     * </pre>
     * <p>
     * 不以零开头，除非是数字 0 本身, 包含数字 0-9
     * <p>
     * 笨方法: 性能太差
     */
    public String multiply1(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        StringBuilder sum = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            int a = num2.charAt(i) - '0';
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int b = a * (num1.charAt(j) - '0') + carry;
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
                ii = num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                jj = num2.charAt(j--) - '0';
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

