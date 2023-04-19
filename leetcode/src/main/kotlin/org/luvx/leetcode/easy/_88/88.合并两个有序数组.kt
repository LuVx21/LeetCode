package org.luvx.leetcode.easy._88

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=88 lang=kotlin
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    /**
     * 3,4,5,6,7,0,0,0,0  1,2,8,9
     * ↓
     * 1,2,3,4,5,6,7,8,9
     */
    fun merge0(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var mi = m - 1
        var ni = n - 1
        var mni = m + n - 1
        while (mni >= 0) {
            if (ni < 0) break
            nums1[mni] = if (mi >= 0 && nums1[mi] > nums2[ni]) nums1[mi--] else nums2[ni--]
            mni--
        }
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var mi = m - 1
        var ni = n - 1
        var mni = m + n - 1
        while (mi >= 0 && ni >= 0) {
            nums1[mni--] = if (nums2[ni] > nums1[mi]) nums2[ni--] else nums1[mi--]
        }
        // nums2中元素可能未完全移入 nums1 中
        System.arraycopy(nums2, 0, nums1, 0, ni + 1)
        // while (ni >= 0) {
        //     nums1[mni--] = nums2[ni--];
        // }
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val nums1 = intArrayOf(3, 4, 5, 6, 7, 0, 0, 0, 0)
    val nums2 = intArrayOf(1, 2, 8, 9)
    exec.merge0(nums1, 5, nums2, nums2.size)
    nums1.contentToString().out()
}