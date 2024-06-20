package org.luvx.leetcode.java.medium._3;
/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

import java.util.HashMap;
import java.util.HashSet;

// @lc code=start
class Solution {
    /**
     * 给定一个字符串, 请你找出其中不含有重复字符的最长子串的长度
     * Usage: pwwkew -> 3
     * <p>
     * map: k: s中的字符;v: 字符出现的最后位置
     * start: 不含有重复字符的子串的起点位置
     */
    public int lengthOfLongestSubstring0(String s) {
        final int length = s.length();
        if (length <= 1) {
            return length;
        }
        var map = new HashMap<Character, Integer>(length);
        int max = 0;
        for (int i = 0, start = 0; i < length; ++i) {
            char key = s.charAt(i);
            Integer integer = map.get(key);
            if (integer != null) {
                start = Math.max(start, integer + 1);
            }
            map.put(key, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        // 题目声明字符串 s 由英文字母、数字、符号和空格组成
        // 所以这里使用一个长度为 256 的数组来模拟 Map 功能
        int[] set = new int[256];
        int max = 0, length = s.length();
        for (int left = 0, right = 0; right < length; right++) {
            var c = s.charAt(right);
            set[c]++;
            while (set[c] > 1) {
                set[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 滑动窗口
     * Usage: pwwkew -> 3
     * <p>
     * set: 存储不重复子串的字符, 遇到重复时, 将第一个重复及之前的字符删除, 重新存储不重复的子串
     */
    public int lengthOfLongestSubstring(String s) {
        final int length = s.length();
        if (length <= 1) {
            return length;
        }
        var set = new HashSet<Character>();
        int max = 0;
        for (int i = 0, j = 0; i < length; ) {
            // i没变化,重复进入循环
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                set.add(s.charAt(i++));
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}
// @lc code=end

