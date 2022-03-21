package org.luvx.leetcode.java.medium._128;
/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (int num : nums) {
            if (set.remove(num)) {
                int temp = num;
                int len = 1;
                while (set.remove(temp - 1)) {
                    temp--;
                }
                len += (num - temp);
                temp = num;
                while (set.remove(temp + 1)) {
                    temp++;
                }
                len += (temp - num);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    /**
     * 负数不可用
     */
    public int longestConsecutive1(int[] nums) {
        BitSet bitSet = new BitSet();
        for (int e : nums) {
            bitSet.set(e);
        }
        int max = 0, tmp = 0;
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                tmp += 1;
            } else {
                max = Math.max(max, tmp);
                tmp = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {0, -1};
        // int[] array = {15, 7, 12, 6, 14, 13, 9, 11};
        Solution exec = new Solution();
        int i = exec.longestConsecutive(array);
        System.out.println(i);
    }
}
// @lc code=end

