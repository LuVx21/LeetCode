package org.luvx.leetcode.java.easy._2129;

/*
 * @lc app=leetcode.cn id=2129 lang=java
 *
 * [2129] 将标题首字母大写
 */

// @lc code=start

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

class Solution {
    /**
     * 快慢指针
     */
    public String capitalizeTitle(String title) {
        char[] chars = title.toCharArray();
        int len = chars.length;

        int start = 0, end = 0;
        while (end <= len) {
            while (end < len && chars[end] != ' ') {
                if (start != end) {
                    chars[end] = toLowerCase(chars[end]);
                }
                end++;
            }
            char c = end - start < 3 ? toLowerCase(chars[start]) : toUpperCase(chars[start]);
            chars[start] = c;

            start = ++end;
        }
        return String.valueOf(chars);
    }

    public String capitalizeTitle1(String title) {
        char[] chars = title.toCharArray();
        int len = chars.length;

        for (int end = 0; end < len; end++) {
            int start = end;
            while (end < len && chars[end] != ' ') {
                chars[end] |= 32;
                end++;
            }
            if (end - start > 2) {
                chars[start] &= ~32;
            }
        }
        return String.valueOf(chars);
    }
}
// @lc code=end

