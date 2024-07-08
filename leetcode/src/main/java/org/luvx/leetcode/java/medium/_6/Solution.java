package org.luvx.leetcode.java.medium._6;
/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int nRows) {
        if (nRows < 2 || nRows >= s.length()) {
            return s;
        }

        byte[] array = s.getBytes();
        byte[] r = new byte[array.length];
        int index = 0;
        int cnt = nRows * 2 - 2;
        for (int row = 0; row < nRows; row++) {
            for (int j = 0; j + row < array.length; j += cnt) {
                r[index++] = array[row + j];
                if (row > 0 && row < nRows - 1 && j + cnt - row < array.length) {
                    r[index++] = array[j + cnt - row];
                }
            }
        }
        return new String(r);
    }

    /**
     * <pre>
     * PAYPALISHIRING
     * 2(模2):
     * 0 2 4 6 8 10 12
     * 1 3 5 7 9 11 13
     * 3(模4):
     * P   A   H   N   0   4   8    12
     * A P L S I I G   1 3 5 7 9 11 13
     * Y   I   R       2   6   10
     * 4(模6):
     * P     I    N   0     6       12
     * A   L S  I G   1   5 7    11 13
     * Y A   H R      2 4   8 10
     * P     I        3     9
     * 5(模8):
     * 0       8
     * 1     7 9
     * 2   6   10
     * 3 5     11 13
     * 4       12
     * </pre>
     */
    public String convert0(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        byte[] array = s.getBytes();
        byte[] r = new byte[array.length];
        int i = 0, index = 0;
        while (index < array.length) {
            r[index++] = array[i];
            i = com(i, numRows, array.length - 1);
        }
        return new String(r);
    }

    private int com(int i, int numRows, int max) {
        int chu = numRows + numRows - 2;
        int mod = i % chu;
        // -1: 最下面, 0: 转折向上第一个
        int i1 = mod - numRows;
        int r = 0;
        if (i1 < -1) {
            r = i + 2 * (-i1 - 1);
        } else {
            r = i + 2 * (numRows - i1 - 2);
        }
        if (r > max) {
            return i1 < -1 ? mod + 1 : chu - mod + 1;
        }
        return r;
    }
}
// @lc code=end

