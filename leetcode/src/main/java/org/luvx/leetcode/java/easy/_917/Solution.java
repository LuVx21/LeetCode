package org.luvx.leetcode.java.easy._917;

/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */
// @lc code=start
class Solution {
    public String reverseOnlyLetters(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        for (int i = 0, j = length - 1; i < j; ) {
            char left = array[i], right = array[j];
            if (isCapital(left) && isCapital(right)) {
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            } else if (!isCapital(left)) {
                i++;
            } else if (!isCapital(right)) {
                j--;
            }
        }
        return String.valueOf(array);
    }

    /**
     * 小写字母:97~122
     * 大写字母:65~90
     * 符号:#$%(35~37)
     */
    private boolean isCapital(char c) {
        int i = c;
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122);
    }
}
// @lc code=end

