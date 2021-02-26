package org.luvx.leetcode.java.medium._3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * 给定一个字符串, 请你找出其中不含有重复字符的最长子串的长度
 */
class Solution {
    /**
     * Usage: pwwkew -> 3
     * <p>
     * map: k: s中的字符;v: 字符出现的最后位置
     * start: 不含有重复字符的子串的起点位置
     */
    public int lengthOfLongestSubstring0(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        int max = 0;
        for (int i = 0, start = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(start, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    /**
     * Usage: pwwkew -> 3
     * <p>
     * set: 存储不重复子串的字符, 遇到重复时, 将第一个重复及之前的字符删除, 重新存储不重复的子串
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            } else {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}

