package org.luvx.leetcode.java.easy._70;

/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     */
    public int climbStairs(int n) {
        if (n > 0 && n <= 2) {
            return n;
        }
        int[] mem = new int[n];
        mem[0] = 1;
        mem[1] = 2;
        for (int i = 2; i < n; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n - 1];
    }

    /*
    private static ConcurrentHashMap<Integer, Integer> cache = new ConcurrentHashMap<>();
    /**
     * 非递归 + 缓存
     *
     * @param n > 0
     * @return
     */
    // public int climbStairs1(int n) {
    //     if (n > 0 && n <= 2) {
    //         return n;
    //     }
    //     return cache.computeIfAbsent(n, (key) -> climbStairs(n - 2) + climbStairs(n - 1));
    // }

    public int climbStairs1(int n) {
        if (n <= 0) return 0;
        if (n <= 2) {
            return n;
        }

        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;

        for (int i = 2; i < n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}
// @lc code=end



