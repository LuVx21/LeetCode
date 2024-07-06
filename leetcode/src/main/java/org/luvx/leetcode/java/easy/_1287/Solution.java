package org.luvx.leetcode.java.easy._1287;
/*
 * @lc app=leetcode.cn id=1287 lang=java
 *
 * [1287] 有序数组中出现次数超过25%的元素
 */

// @lc code=start
class Solution {
    public int findSpecialInteger(int[] arr) {
        int level = (int) Math.ceil(arr.length * 0.25), cnt = 1;
        if (arr.length % 4 == 0) {
            level++;
        }
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            if (num != arr[i - 1]) {
                cnt = 1;
                continue;
            }
            cnt++;
            if (cnt >= level) {
                return num;
            }
        }
        return arr[0];
    }
}
// @lc code=end
