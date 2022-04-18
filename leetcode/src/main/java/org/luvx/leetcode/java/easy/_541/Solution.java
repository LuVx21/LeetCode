package org.luvx.leetcode.java.easy._541;
/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */
// @lc code=start

import java.util.AbstractMap;
import java.util.List;

class Solution {
    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * <p>
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     * <pre>
     *     abcdefg,2 -> bacdfeg
     *     abcd,2 -> bacd
     * </pre>
     */
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        int left = 0;
        while (left < array.length) {
            reverse(array, left, Math.min(left + k - 1, array.length - 1));
            left += 2 * k;
        }
        return new String(array);
    }

    public String reverseStr1(String s, int k) {
        if (s == null) {
            return "";
        }
        char[] array = s.toCharArray();
        int slow = 0, fast = 0;
        while (fast < array.length) {
            for (int i = 0; i < Math.min(array.length, 2 * k) - 1 && fast < array.length - 1; i++) {
                fast++;
            }
            int t = (fast - slow + 1) < k ? fast : slow + k - 1;
            reverse(array, slow, t);
            fast = slow = fast + 1;
        }
        return new String(array);
    }

    private void reverse(char[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        final Solution exec = new Solution();
        List.of(
                new AbstractMap.SimpleEntry<>("abcdefg", 2),
                new AbstractMap.SimpleEntry<>("abcd", 2),
                new AbstractMap.SimpleEntry<>("abcdefghijklmn", 6)
        ).forEach(e -> System.out.println(exec.reverseStr1(e.getKey(), e.getValue())));
    }
}
// @lc code=end

