package org.luvx.leetcode.java.medium._146;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(4);
        for (int i = 0; i < 10; i++) {
            cache.put(i, i);
            cache.get(0);
            System.out.println(cache);
        }
    }
}