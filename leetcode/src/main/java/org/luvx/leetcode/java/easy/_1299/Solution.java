package org.luvx.leetcode.java.easy._1299;
/*
 * @lc app=leetcode.cn id=1299 lang=java
 *
 * [1299] 将每个元素替换为右侧最大元素
 */

// @lc code=start
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] r = new int[arr.length];
        int max = r[r.length - 1] = -1, index = arr.length - 2;
        for (int i = arr.length - 1; i > 0; i--) {
            int num = arr[i];
            if (num > max) {
                max = num;
            }
            r[index--] = max;
        }
        return r;
    }
}
// @lc code=end
