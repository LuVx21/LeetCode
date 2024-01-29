package org.luvx.leetcode.java.medium._421;
/*
 * @lc app=leetcode.cn id=421 lang=java
 *
 * [421] 数组中两个数的最大异或值
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * <pre>
     *     a ^ b = c 那么 c ^ b = a
     *     同样: (a ^ b) ^ b = a
     * </pre>
     * [3,10,5,25,2,8]
     * mask: 10000 -> 11000 -> 11100 -> 11110 -> 11111
     * 使用mask从高向低
     */
    public int findMaximumXOR(int[] nums) {
        int _max = 0;
        for (int x : nums) {
            _max = Math.max(_max, x);
        }

        int max = 0, mask = 0;
        // 这一块两种写法
        // for (int i = 31 - Integer.numberOfLeadingZeros(_max); i >= 0; i--) {
        //     mask |= (1 << i);
        //     int tmp = max | (1 << i);
        for (int i = Integer.highestOneBit(_max); i > 0; i >>>= 1) {
            mask |= i; // 用于覆盖高n位
            int tmp = max | i; // 此时max在该位之前都已取到最大,用i或操作表示期望本次循环能找到使该位为1的数

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                // 利用mask的高n位,取num的高n位,t为0时说明num的高n位都为0
                int t = num & mask;
                // 存在则说明该位能取到1(set中存在一个数和当前的t异或操作得到tmp)
                if (set.contains(t ^ tmp)) {
                    max = tmp;
                    break;
                }
                set.add(t);
            }
        }
        return max;
    }

    public int findMaximumXOR_0(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Trie root = getTrie(nums);
        return getMax(nums, root);
    }

    private Trie getTrie(int[] nums) {
        Trie root = new Trie();
        for (int num : nums) {
            Trie curNode = root;
            for (int i = 31; i >= 0; i--) {
                // 右移后取最低位
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit] == null) {
                    curNode.children[curBit] = new Trie();
                }
                curNode = curNode.children[curBit];
            }
        }
        return root;
    }

    private int getMax(int[] nums, Trie root) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            Trie curNode = root;
            int curSum = 0;
            for (int i = 31; i >= 0; i--) {
                int curBit = (num >>> i) & 1;
                if (curNode.children[curBit ^ 1] != null) {
                    curSum += (1 << i);
                    curNode = curNode.children[curBit ^ 1];
                } else {
                    curNode = curNode.children[curBit];
                }
            }
            max = Math.max(curSum, max);
        }
        return max;
    }

    class Trie {
        Trie[] children;

        public Trie() {
            children = new Trie[2];
        }
    }
}
// @lc code=end
