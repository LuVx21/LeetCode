/*
 * @lc app=leetcode.cn id=316 lang=java
 *
 * [316] 去除重复字母
 */
class Solution {
    /**
     * <pre>
     *   bcabc -> abc
     *   cbacdcbc -> acdb
     *   dcbdedcd -> bdec
     * </pre>
     * 给定一个仅包含小写字母的字符串，去除字符串中重复的字母，使得每个字母只出现一次。
     * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     * <p>
     * 去重, 排序
     */
    public String removeDuplicateLetters(String s) {
        return method0(s);
    }

    /**
     * voted
     */
    public String method0(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            if (--array[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return s.length() == 0 ? ""
                : s.charAt(pos) + method0(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}

