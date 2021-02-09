package org.luvx.leetcode.easy._1550

import org.luvx.leetcode.out

/*
 * @lc app=leetcode.cn id=1550 lang=kotlin
 *
 * [1550] 存在连续三个奇数的数组
 */

// @lc code=start
class Solution {
    /**
     * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
     * 如果存在，请返回 true ；否则，返回 false 。
     * 1,2,34,3,4,5,7,23,12 -> 5 7 23
     */
    fun threeConsecutiveOdds(arr: IntArray): Boolean {
        var i = 0
        while (i < arr.size - 2) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true
            }
            i++
        }
        return false
    }

    fun threeConsecutiveOdds1(arr: IntArray): Boolean {
        var cnt = 0
        for (i in arr) {
            cnt = if (i % 2 != 0) cnt + 1 else 0
            if (cnt == 3) {
                return true
            }
        }
        return false
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val array = intArrayOf(0, 2, 4, 1, 3, 5)
//    val array = intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)
//    val array = intArrayOf(2, 6, 4, 1)
    exec.threeConsecutiveOdds(array).out()
}