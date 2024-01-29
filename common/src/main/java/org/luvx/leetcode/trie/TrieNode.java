package org.luvx.leetcode.trie;

import jakarta.annotation.Nullable;

public class TrieNode {
    public char       val;
    /**
     * 通常情况,分叉数量有限
     */
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode(char c) {
        this();
        this.val = c;
    }

    public TrieNode(char c, TrieNode[] children) {
        this.val = c;
        this.children = children;
    }

    public static TrieNode insert(@Nullable TrieNode root, char[] array) {
        if (root == null) {
            root = new TrieNode();
        }
        TrieNode cur = root;
        for (char c : array) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode(c);
            }
            cur = cur.children[c - 'a'];
        }
        return root;
    }
}
