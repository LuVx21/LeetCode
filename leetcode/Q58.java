package org.luvx;

/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 *
 * https://leetcode-cn.com/problems/length-of-last-word/description/
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (28.44%)
 * Total Accepted:    16K
 * Total Submissions: 56.4K
 * Testcase Example:  '"Hello World"'
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 *
 */

/**
 * "a " 中最后一个单词为a, 返回值为1
 * "a"
 */
class Q58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(" a "));
    }

    public static int lengthOfLastWord1(String s) {
        String[] array = s.trim().split(" ");
        return array[array.length - 1].length();
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int right = s.length() - 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if ((s.charAt(i) == ' ')) {
                return right - i;
            } else if (i == 0) {
                return s.length();
            }
        }
        return 0;
    }

}
