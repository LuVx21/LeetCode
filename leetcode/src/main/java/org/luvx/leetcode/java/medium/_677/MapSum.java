package org.luvx.leetcode.java.medium._677;

// @lc code=start

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */
class MapSum {
    Map<String, Integer> map = new HashMap<>();
    TrieNode root = new TrieNode();

    public MapSum() {
    }

    public void insert(String key, int val) {
        int diff = val - map.getOrDefault(key, 0);
        TrieNode cur = root;
        for (char c : key.toCharArray()) {
            int i = c - 'a';
            if (cur.child[i] == null) {
                cur.child[i] = new TrieNode();
            }
            cur = cur.child[i];
            cur.sum += diff;
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            TrieNode child = cur.child[c - 'a'];
            if (child == null) {
                return 0;
            }
            cur = child;
        }
        return cur.sum;
    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int sum = 0;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end

