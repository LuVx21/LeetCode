package org.luvx.leetcode.java.easy._496;
/*
 * @lc app=leetcode.cn id=496 lang=java
 *
 * [496] 下一个更大元素 I
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// @lc code=start
class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] r = new int[nums1.length];

        Stack<Integer> stack = new Stack<>();
        // 原数-第一个更大元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.add(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            r[i] = map.getOrDefault(nums1[i], -1);
        }
        return r;
    }

    /**
     * 递减单调栈
     * 关联: {@link org.luvx.leetcode.java.easy._1475.Solution#finalPrices(int[])}
     * <pre>
     *     [3,1,5,7,9,2,6] [1,2,3,5,6,7,9,11]
     * </pre>
     */
    public int[] nextGreaterElement0(int[] nums1, int[] nums2) {
        int[] r = new int[nums1.length];
        // 元素-index
        Map<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            map.putIfAbsent(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        for (int j = nums2.length - 1; j >= 0; j--) {
            int num = nums2[j];
            Integer i = map.get(num);
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }
            if (i != null) {
                r[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(num);
        }

        return r;
    }
}
// @lc code=end
