package org.luvx.leetcode.java.easy._2068;

// @lc code=start
/*
 * @lc app=leetcode.cn id=2068 lang=java
 *
 * [2068] 检查两个字符串是否几乎相等
 */
class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] array = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            array[word1.charAt(i) - 'a']++;
            array[word2.charAt(i) - 'a']--;
        }
        for (int i : array) {
            if (i > 3 || i < -3) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

