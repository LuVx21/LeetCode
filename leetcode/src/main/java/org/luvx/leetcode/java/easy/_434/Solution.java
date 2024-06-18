package org.luvx.leetcode.java.easy._434;
/*
 * @lc app=leetcode.cn id=434 lang=java
 *
 * [434] 字符串中的单词数
 */

// @lc code=start
class Solution {
    /**
     * " a b c  d "
     */
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }

        return count;
    }

    public int countSegments0(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int left = 0, right = s.length() - 1;
        while (left < s.length() && s.charAt(left) == ' ') {
            left++;
        }
        while (right > left && s.charAt(right) == ' ') {
            right--;
        }
        if (right < left) {
            return 0;
        }

        int cnt = 0;
        boolean noSpace = true;
        for (int i = left; i < right; i++) {
            if (s.charAt(i) != ' ') {
                noSpace = true;
            } else {
                if (noSpace) {
                    cnt++;
                    noSpace = false;
                }
            }
        }
        return cnt + 1;
    }
}
// @lc code=end

