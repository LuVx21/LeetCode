package org.luvx.leetcode.java.medium._208;

// @lc code=start
/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */
class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int k = (int) c - 97;
            TrieNode child = r.children[k];
            if (child == null) {
                r.children[k] = child = new TrieNode(c);
            }
            r = child;
        }
        r.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int k = (int) c - 97;
            TrieNode child = r.children[k];
            if (child == null) {
                return false;
            }
            r = child;
        }
        return r.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode r = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int k = (int) c - 97;
            TrieNode child = r.children[k];
            if (child == null) {
                return false;
            }
            r = child;
        }
        return true;
    }

    static class TrieNode {
        public char       val;
        public boolean    isWord;
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
        }

        public TrieNode(char c) {
            this.val = c;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

