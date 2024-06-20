package org.luvx.leetcode.java.easy._28;
/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
     if (haystack == null || needle == null) {
            return -1;
        } else if (needle.isEmpty()) {
            return 0;
        } else if (haystack.isEmpty()) {
            return -1;
        } else if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int j = 0; j < haystack.length(); j++) {
            int temp = j;
            for (int i = 0; i < needle.length(); ) {
                if (temp < haystack.length() && haystack.charAt(temp) == needle.charAt(i)) {
                    if (i == needle.length() - 1) {
                        return j;
                    }
                    temp++;
                    i++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

