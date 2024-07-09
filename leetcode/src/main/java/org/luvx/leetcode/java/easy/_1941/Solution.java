package org.luvx.leetcode.java.easy._1941;
/*
 * @lc app=leetcode.cn id=1941 lang=java
 *
 * [1941] 检查是否所有字符出现次数相同
 */

// @lc code=start
class Solution {
    public boolean areOccurrencesEqual(String s) {
        short[] array = new short[26];
        int count = 0;
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            var b = bytes[i];
            array[b - 'a']++;
            if (i == bytes.length - 1) {
                count = array[b - 'a'];
            }
        }

        for (short cnt1 : array) {
            if (cnt1 != 0 && count != cnt1) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
