package org.luvx.leetcode.kotlin.easy._1636

import org.luvx.coding.common.enhancer.out

/*
 * @lc app=leetcode.cn id=1636 lang=kotlin
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start
class Solution {
    /**
     * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
     * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
     */
    fun frequencySort0(nums: IntArray): IntArray {
        return nums.toList()
            .groupingBy { it }
            .eachCount()
            .toList()
            .sortedWith(
                compareBy<Pair<Int, Int>> { (_, freq) -> freq }.thenByDescending { (num) -> num }
            )
            .flatMap { List(it.second) { _ -> it.first } }
            .toIntArray()
    }

    fun frequencySort(nums: IntArray): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return nums
            .sortedWith { a, b -> if (map[a] == map[b]) b - a else map[a]!! - map[b]!! }
            .toIntArray()
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    var array = intArrayOf(1, 1, 2, 2, 2, 3)
    exec.frequencySort(array).contentToString().out()
    array = intArrayOf(2, 3, 1, 3, 2)
    exec.frequencySort(array).contentToString().out()
}
