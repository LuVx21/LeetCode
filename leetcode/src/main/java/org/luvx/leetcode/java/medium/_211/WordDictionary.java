package org.luvx.leetcode.java.medium._211;
/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
// 208 题目 - 字典树
class WordDictionary {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int k = c - 'a';
            TrieNode child = r.children[k];
            if (child == null) {
                r.children[k] = child = new TrieNode();
            }
            r = child;
        }
        r.word = word;
    }

    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return !node.word.equals("");
        }
        char c = chs[k];
        if (c != '.') {
            int i = c - 'a';
            return node.children[i] != null
                    && match(chs, k + 1, node.children[i]);
        }
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                if (match(chs, k + 1, node.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private static class TrieNode {
        public String word = "";
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

