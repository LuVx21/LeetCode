package org.luvx.leetcode.java.easy._14;
/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */
// @lc code=start

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = Arrays.stream(strs)
                // .map(String::length).min(Integer::compare).orElse(0)
                .mapToInt(String::length).min().getAsInt();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j].charAt(i) != strs[j + 1].charAt(i)) {
                    return result.toString();
                }
                if (j + 1 == strs.length - 1) {
                    result.append(strs[j].charAt(i));
                }
            }
        }
        return result.toString();
    }
}
// @lc code=end

