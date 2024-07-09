package main

/*
 * @lc app=leetcode.cn id=1929 lang=golang
 *
 * [1929] 数组串联
 */

// @lc code=start
func getConcatenation(nums []int) []int {
    //return append(nums, nums...)
    _len := len(nums)
    r := make([]int, 2*_len)
    for i := 0; i < 2*_len; i++ {
        r[i] = nums[i%_len]
    }
    return r
}

// @lc code=end
