package org.luvx.leetcode.java.medium._208;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TrieTest {
    @Test
    public void test() {
        Trie trie = new Trie();

        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));
        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }
}