package org.luvx.leetcode.java.easy._387;

/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */
// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    /**
     * 仅有小写字母
     * <pre>
     * loveleetcode
     *   2
     * </pre>
     */
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 可有任何字符
     */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? Integer.MAX_VALUE : i);
        }
        Integer result = map.values().stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
// @lc code=end

