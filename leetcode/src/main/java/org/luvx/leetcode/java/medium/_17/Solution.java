package org.luvx.leetcode.java.medium._17;
/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    final char[][] d = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }

        List<String> result = new ArrayList<>();
        // runtime beats 100 %, 字符串拼接确实耗时
        backtrack1(digits, 0, new StringBuilder(), result);
        // 耗时长
        // backtrack0(digits, 0, "", result);
        return result;
    }

    void backtrack1(String digits, int index, StringBuilder sb, List<String> result) {
        if (index >= digits.length()) {
            result.add(sb.toString());
            return;
        }

        char[] chars = d[digits.charAt(index) - '2'];
        for (char c : chars) {
            sb.append(c);
            backtrack1(digits, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    void backtrack0(String digits, int index, String prefix, List<String> result) {
        if (index >= digits.length()) {
            result.add(prefix);
            return;
        }

        char[] chars = d[digits.charAt(index) - '2'];
        for (char c : chars) {
            backtrack0(digits, index + 1, prefix + c, result);
        }
    }
}
// @lc code=end
