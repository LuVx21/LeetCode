package org.luvx.leetcode.java.medium._438;
/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class Solution {
    /**
     * cbaebabacd,abc
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        int[] sArray = freq(s.substring(0, pLen)), pArray = freq(p);
        if (Arrays.equals(pArray, sArray)) {
            list.add(0);
        }

        for (int i = 1; i <= sLen - pLen; i++) {
            sArray[s.charAt(i - 1) - 'a']--;
            sArray[s.charAt(i + pLen - 1) - 'a']++;
            if (Arrays.equals(pArray, sArray)) {
                list.add(i);
            }
        }
        return list;
    }

    private int[] freq(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        Map.of(
                "cbaebabacd", "abc",
                "abab", "ab"
        ).forEach((k, v) ->
                System.out.println(exec.findAnagrams(k, v))
        );
    }
}
// @lc code=end

