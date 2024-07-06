package org.luvx.leetcode.java.easy._1122;
/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    /**
     * 另一种方法:
     * 1. arr1排序
     * 2. 遍历arr2[i], 在arr1中找到所有arr2[i], 写入结果r, 同时arr1中置为-1
     * 3. 遍历arr1, 依次找到不为-1的, 写入结果r
     * 4. 结束,返回r
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final short[] index = new short[1001];
        for (int i : arr1) {
            index[i]++;
        }

        final int[] r = new int[arr1.length];
        int i = 0;
        for (int j : arr2) {
            short cnt = index[j];
            for (short k = 0; k < cnt; k++) {
                r[i++] = j;
                index[j]--;
            }
        }
        for (int j = 0; j < index.length; j++) {
            short cnt = index[j];
            if (cnt == 0) {
                continue;
            }
            for (short k = 0; k < cnt; k++) {
                r[i++] = j;
            }
        }

        return r;
    }
}
// @lc code=end
