package org.luvx.leetcode.java.medium._390;
/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start

import java.util.List;

class Solution {
    /**
     * 1,2,3,4,5,6,7,8,9,10->2,4,6,8,10->4,8->8
     * 1,2,3,4,5,6,7,8,9->2,4,6,8->2,6->6
     * 1,2,3,4,5,6,7,8->2,4,6,8->2,6->6
     */
    public int lastRemaining(int n) {
        boolean flag = true;
        int len = n, step = 1, left = 1;
        while (len > 1) {
            // 如果是奇数长度, 最左边的会被删除
            if (flag || len % 2 == 1) {
                left += step;
            }
            len /= 2;
            step *= 2;
            flag = !flag;
        }
        return left;
    }

    public int lastRemaining1(int n) {
        if (n == 1) {
            return 1;
        }
        // 公式: f(n) = 2(n/2 - (f(n/2) - 1))
        return (n / 2 - lastRemaining(n / 2) + 1) * 2;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        List.of(10, 9).forEach(n ->
                System.out.println(exec.lastRemaining(n))
        );
    }
}
// @lc code=end

