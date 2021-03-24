package org.luvx.leetcode.java.easy._916;

// @lc code=start

/*
 * @lc app=leetcode.cn id=961 lang=java
 *
 * [961] 重复 N 次的元素
 */
class Solution {
    /**
     * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
     * 返回重复了 N 次的那个元素。
     * <p>
     * 1, 2, 3, 3 -> 3
     */
    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; ++i) {
            if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
                return A[i];
            }
        }
        return A[0];
    }
}
// @lc code=end
