package main

import "fmt"

/*
 * @lc app=leetcode.cn id=540 lang=golang
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
// 也可利用 只出现一次的数字 类似方式
func singleNonDuplicate(nums []int) int {
    left, right := 0, len(nums)-1
    for left < right {
        mid := left + (right-left)>>1
        //异或, 奇数: -1, 偶数:+1
        if nums[mid] == nums[mid^1] {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return nums[left]
}
func singleNonDuplicate0(nums []int) int {
    _len := len(nums)
    left, right := 0, _len-1
    for left < right {
        mid := left + (right-left)>>1
        num := nums[mid]
        if mid%2 == 0 {
            if mid+1 < _len && num == nums[mid+1] {
                left = mid + 1
            } else {
                right = mid
            }
        } else {
            if mid-1 >= 0 && nums[mid-1] == num {
                left = mid + 1
            } else {
                right = mid
            }
        }
    }
    return nums[right]
}

// @lc code=end

func main() {
    array := []int{1, 1, 2, 3, 3, 4, 4, 8, 8}
    array1 := []int{3, 3, 7, 7, 10, 11, 11}
    for _, a := range [][]int{array, array1} {
        duplicate := singleNonDuplicate(a)
        fmt.Println(duplicate)
    }
}
