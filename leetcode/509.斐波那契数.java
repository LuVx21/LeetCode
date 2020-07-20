/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    /**
     * 0 <= N <= 30
     *
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }

        if (N == 0 || N == 1) {
            return N;
        }
        int[] array = new int[N + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i <= N; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[N];

        // 循环1
        // int no0 = 0, no1 = 1, data = 0;
        // for (int i = 0; i < N - 1; i++) {
        //     data = no0 + no1;
        //     no0 = no1;
        //     no1 = data;
        // }
        // return data;

        // 递归 不用考虑
        // return fib(N - 1) + fib(N - 2);
    }
}
// @lc code=end

