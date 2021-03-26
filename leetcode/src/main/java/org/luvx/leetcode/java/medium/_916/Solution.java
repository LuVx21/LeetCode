package org.luvx.leetcode.java.medium._916;

// @lc code=start

import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=916 lang=java
 *
 * [916] 单词子集
 */
class Solution {
    /**
     * 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
     * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。
     * 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
     * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
     * 你可以按任意顺序以列表形式返回 A 中所有的通用单词。
     */
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] array = new int[26];
        for (String word : B) {
            int[] temp = count(word);
            for (int i = 0; i < 26; i++) {
                array[i] = Math.max(array[i], temp[i]);
            }
        }

        List<String> result = new ArrayList<>();
        search:
        for (String word : A) {
            int[] temp = count(word);
            for (int i = 0; i < 26; i++)
                if (temp[i] < array[i])
                    continue search;
            result.add(word);
        }
        return result;
    }

    public int[] count(String s) {
        int[] result = new int[26];
        for (char c : s.toCharArray()) {
            result[c - 'a']++;
        }
        return result;
    }
}
// @lc code=end
