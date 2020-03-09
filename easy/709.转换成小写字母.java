/*
 * @lc app=leetcode.cn id=709 lang=java
 *
 * [709] 转换成小写字母
 */

// @lc code=start
class Solution {
    public String toLowerCase0(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        char[] array = str.toCharArray();
        for (int i = 0, length = array.length; i < length; i++) {
            char c = array[i];
            if (c >= 65 && c <= 90) {
                array[i] = (char) (c + 32);
            }
        }

        return new String(array);
    }

    /**
     * A: 65 -> 0100 0001
     * |:       0010 0000
     * a: 97 -> 0110 0001
     * <p>
     * -> 大写 &= -33
     * -> 小写 |= 32
     * -> 相反 ^= 32
     *
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 65 && c <= 90) {
                // c = (char) (c + 32);
                // c = (char) (c | 0b0010_0000);
                c |= 0b0010_0000;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
// @lc code=end

