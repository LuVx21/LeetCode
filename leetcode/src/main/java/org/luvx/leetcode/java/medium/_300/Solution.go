package main

import (
    "fmt"
    "math"
)

/*
 * @lc app=leetcode.cn id=300 lang=golang
 *
 * [300] 最长递增子序列
 */

// @lc code=start
func lengthOfLIS(nums []int) int {
    dp := make([]int, 0)
    dp = append(dp, nums[0])
    for i := 1; i < len(nums); i++ {
        num := nums[i]
        if num > dp[len(dp)-1] {
            dp = append(dp, num)
            continue
        }
        for j := 0; j < len(dp); j++ {
            if dp[j] >= num {
                dp[j] = num
                break
            }
        }
    }
    return len(dp)
}
func lengthOfLIS0(nums []int) int {
    if len(nums) == 0 {
        return 0
    }
    dp := make([]int, len(nums)+1)
    dp[0] = math.MinInt
    dp[1] = nums[0]

    maxL := 1
    for i := 1; i < len(nums); i++ {
        num := nums[i]
        if dp[maxL] < num {
            maxL++
            dp[maxL] = num
            continue
        }

        for j := maxL - 1; j >= 0; j-- {
            if num > dp[j] {
                println(j)
                dp[j+1] = num
                break
            }
        }
        // 使用二叉搜索来确定 num 应放入 dp 数组中的哪个位置
        //j := searchDP(num, dp, maxL)
        //dp[j+1] = num
    }
    return maxL
}

// searchDP 不正确
func searchDP(num int, dp []int, max int) int {
    left, right := 0, max-1
    for left < right {
        mid := left + (right-left)/2
        if dp[mid] < num {
            left = mid
        } else {
            right = mid
        }
    }
    return left
}

// @lc code=end

func main() {
    lis := lengthOfLIS([]int{4, 10, 4, 3, 8, 9})
    fmt.Println("---\n", lis)
}
