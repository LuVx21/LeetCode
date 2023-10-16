package org.luvx.leetcode.tree;

public class TrieNode {
    public char       val;
    public boolean    isWord;
    public TrieNode[] children;

    public TrieNode(char c) {
        this.val = c;
    }

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode(char c, TrieNode[] children) {
        this.val = c;
        this.children = children;
    }
}
