package org.luvx.leetcode.java.easy._557;
/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] == ' ') {
                swap(array, start, i);
                start = i + 2;
            }
        }
        swap(array, start, array.length - 1);
        return new String(array);
    }

    void swap(char[] array, int i, int j) {
        while (i < j) {
            var t = array[i];
            array[i++] = array[j];
            array[j--] = t;
        }
    }
}
// @lc code=end
