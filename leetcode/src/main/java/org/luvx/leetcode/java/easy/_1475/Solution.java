package org.luvx.leetcode.java.easy._1475;
/*
 * @lc app=leetcode.cn id=1475 lang=java
 *
 * [1475] 商品折扣后的最终价格
 */

import java.util.Stack;

// @lc code=start
class Solution {
    /**
     * i右边 第一个 价格 <= i的价格
     * 递增单调栈
     * <p>
     * [8,4,6,2,3] -> [4,2,4,2,3]
     */
    public int[] finalPrices(int[] prices) {
        int[] r = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            r[i] = prices[i] - check(prices[i], i, prices);
        }
        return r;
    }

    public int check(int num, int index, int[] prices) {
        for (int i = index + 1; i < prices.length; i++) {
            if (num >= prices[i]) {
                return prices[i];
            }
        }
        return 0;
    }

    public int[] finalPrices0(int[] prices) {
        int len = prices.length;
        int[] r = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            int price = prices[i];
            // 保留小的: 把你自身大的都移除,之后把自身放进去
            while (!stack.isEmpty() && stack.peek() > price) {
                stack.pop();
            }

            r[i] = price - (stack.isEmpty() ? 0 : stack.peek());
            stack.push(price);
        }
        return r;
    }
}
// @lc code=end
