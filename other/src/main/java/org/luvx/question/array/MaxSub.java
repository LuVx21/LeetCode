package org.luvx.question.array;

import java.util.Arrays;
import java.util.Stack;

public class MaxSub {

    /**
     * leetcode-84 扩展
     * 来源: https://leetcode-cn.com/circle/discuss/pv7bY1/
     * <p>
     * 值最大区间
     * 无序数组，求一个值最大的区间，区间计算方案为：区间和 * 区间最小值（2020.09 字节跳动-电商-后端）
     * <p>
     * 给定一个数组，要求选出一个区间, 使得该区间是所有区间中经过如下计算的值最大的一个：
     * 区间中的最小数 * 区间所有数的和。
     * 1. 数组中的元素都是非负数。
     * 2. 输入两行，第一行n表示数组长度，第二行为数组序列。输出最大值。
     * <p>
     * 例:
     * 输入: 6 2 1
     * 输出: 36
     * 解释：满足条件区间是[6] = 6 * 6 = 36;
     */
    public int maxSub(int[] array) {
        int len = array.length;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + array[i - 1];
        }

        System.out.println("  " + Arrays.toString(array));
        System.out.println(Arrays.toString(sums));

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && array[stack.peek()] >= array[i]) {
                int pop = array[stack.pop()];
                int l = stack.empty() ? -1 : stack.peek();
                // l和r是边界，因此区间是[l+1,r-1]，其区间和 sums[r+1]-sums[l]
                int dist = sums[i] - sums[l + 1];
                max = Math.max(max, pop * dist);
            }
            stack.push(i);
        }

        while (!stack.empty()) {
            int pop = array[stack.pop()];
            int l = stack.empty() ? -1 : stack.peek();
            int dist = sums[len] - sums[l + 1];
            max = Math.max(max, pop * dist);
        }

        return max;
    }
}
