package org.luvx.question

/**
 * @author: Ren, Xie
 */
/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 首先跳跃一个长度, 为[1, length/2)
 *
 *
 * 之后跳跃长度为此处的元素值
 *
 *
 * 判断能到达最后一个位置时, 最小的跳跃次数, 不能则返回-1
 *
 *
 * 7 5 9 4 2 6 8 3 5 4 3 9 -> 2
 * 1 2 3 7 1 5 9 3 2 1 -> -1
 * 1 2 3 7 5 5 9 3 2 1 -> 2
 *
 * @param nums
 * @return
 */
fun steps(nums: IntArray): Int {
    var result = -1
    val len = nums.size
    val half = len / 2
    for (i in 1 until half) {
        var index = i
        var count = 0
        while (true) {
            if (index <= len - 1) {
                count++
                if (index == len - 1) {
                    break
                }
            } else if (index > len - 1) {
                count = -1
                break
            }
            val num = nums[index]
            index += num
        }
        if (result == -1) {
            result = count
        } else {
            if (count != -1) {
                result = count.coerceAtMost(result)
            }
        }
    }
    return result
}