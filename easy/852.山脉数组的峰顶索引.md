/*
 * @lc app=leetcode.cn id=852 lang=java
 *
 * [852] 山脉数组的峰顶索引
 */
class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int length = A.length;
        if (length < 3 || length > 10000) {
            return -1;
        }

        for (int i = 0; i < length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}

