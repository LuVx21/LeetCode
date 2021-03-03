package org.luvx.leetcode.java.hard._84;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start

import java.util.List;
import java.util.Stack;

class Solution {
    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 2,1,5,6,2,3 -> 10
     * 1,2,4,5,3 -> 9
     * 方案:
     * 1. 滑动窗口(下策)
     * 2. array[i]最小时的最大区间, 计算, 比较取最大
     * 3. 单调栈
     * <p>
     * ↓
     * <p>
     * max(区间最小值 * 区间大小)
     * 扩展, 如:
     * max(区间最小值 * 区间和)
     */
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                final int min = heights[stack.pop()];
                int l = stack.empty() ? -1 : stack.peek();
                max = Math.max(max, min * (i - l - 1));
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            final int min = heights[stack.pop()];
            int l = stack.empty() ? -1 : stack.peek();
            max = Math.max(max, min * (heights.length - l - 1));
        }
        return max;
    }

    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        final int len = heights.length;
        int[] lessFromLeft = new int[len];
        int[] lessFromRight = new int[len];
        lessFromLeft[0] = -1;
        lessFromRight[len - 1] = len;

        for (int i = 1; i < len; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
        for (int i = len - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < len && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
        return max;
    }

    public int largestRectangleArea0(int[] heights) {
        final int len = heights.length;
        int max = 0;
        for (int i = 0; i < len; i++) {
            final int min = heights[i];
            int start = 0, end = len - 1;
            for (int j = i - 1; j >= 0; j--) {
                if (heights[j] < min) {
                    start = j + 1;
                    break;
                }
            }
            for (int j = i + 1; j < len; j++) {
                if (min > heights[j]) {
                    end = j - 1;
                    break;
                }
            }
            max = Math.max(max, min * (end - start + 1));
        }
        return max;
    }

    public static void main(String[] args) {
        final Solution exec = new Solution();
        List<int[]> list = List.of(
                new int[]{1, 2, 4, 5, 3},
                new int[]{1, 2, 4, 5, 3, 2},
                new int[]{1, 2, 4, 5, 3, 4},
                new int[]{1, 2, 4, 5, 3, 6},
                new int[]{6, 2, 1},
                new int[]{1, 2, 6},
                new int[]{3, 1, 6, 4, 5, 2},
                new int[]{5, 6},
                new int[]{2, 1, 5, 6, 2, 3}
        );
        for (int[] array : list) {
            System.out.print(
                    exec.largestRectangleArea(array) + " "
            );
            System.out.println(
                    exec.largestRectangleArea1(array)
            );
        }
    }
}
// @lc code=end

