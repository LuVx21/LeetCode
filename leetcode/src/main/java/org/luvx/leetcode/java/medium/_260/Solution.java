package org.luvx.leetcode.java.medium._260;
/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

import java.util.HashSet;

// @lc code=start
class Solution {
    /**
     * 1. 排序后处理
     * 2. set
     */
    public int[] singleNumber(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }

        // 此时: xorSum=a ^ b, 因为a,b不同, 所以异或结果不为0, 二进制表现中,肯定存在1
        // Brian Kernighan算法, 提取出二进制里最右侧的1, 根据最后的1, 将a,b分开
        int lowbit = xorSum & -xorSum;

        int eor2 = 0;
        for (int num : nums) {
            // num的lowbit位置为0
            if ((num & lowbit) == 0) {
                eor2 ^= num;
            }
        }
        return new int[]{eor2, xorSum ^ eor2};
    }

    public int[] singleNumber1(int[] nums) {
        int[] r = new int[2];
        var set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        int index = 0;
        for (Integer integer : set) {
            r[index++] = integer;
        }
        return r;
    }
}
// @lc code=end
