package main

import "fmt"

/*
 * @lc app=leetcode.cn id=1748 lang=golang
 *
 * [1748] 唯一元素的和
 */

// @lc code=start
func sumOfUnique(nums []int) int {
    numsMap := make(map[int]int, len(nums))
    for _, item := range nums {
        if _, ok := numsMap[item]; ok {
            numsMap[item] += 1
        } else {
            numsMap[item] = 1
        }
    }

    sum := 0
    for k, v := range numsMap {
        if v == 1 {
            sum += k
        }
    }

    return sum
}
func sumOfUnique0(nums []int) int {
    index := make([]int, 100)
    for i := 0; i < len(nums); i++ {
        index[nums[i]-1]++
    }
    sum := 0
    for i, c := range index {
        if c == 1 {
            sum += i + 1
        }
    }
    return sum
}

// @lc code=end
func main() {
    array := []int{1, 2, 3, 4, 5}
    unique := sumOfUnique(array)
    fmt.Println(unique)
}
