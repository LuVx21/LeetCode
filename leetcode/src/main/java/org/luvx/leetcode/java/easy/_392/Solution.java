package org.luvx.leetcode.java.easy._392;
/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start
class Solution {
    /**
     * 数组比直接读string快
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        char[] ss = s.toCharArray(), tt = t.toCharArray();
        for (int si = 0, ti = 0; ti < t.length(); ti++) {
            if (tt[ti] == ss[si]) {
                si++;
            }
            if (si == s.length()) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        for (int si = 0, ti = 0; si < s.length() && ti < t.length(); ti++) {
            if (s.charAt(si) == t.charAt(ti)) {
                if (si >= s.length() - 1) {
                    return true;
                }
                si++;
            }
        }
        return false;
    }
}
// @lc code=end
