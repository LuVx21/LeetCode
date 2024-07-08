package main

import (
    "fmt"
    "math"
    "slices"
)

/*
 * @lc app=leetcode.cn id=16 lang=golang
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
func threeSumClosest(nums []int, target int) (r int) {
    slices.Sort(nums)
    n := len(nums)

    minDiff := math.MaxInt
    for i, num := range nums[:n-2] {
        if i > 0 && num == nums[i-1] {
            continue
        }

        sum := num + nums[i+1] + nums[i+2]
        if sum > target {
            if sum-target < minDiff {
                r = sum
            }
            break
        }

        sum = num + nums[n-1] + nums[n-2]
        if sum < target {
            if target-sum < minDiff {
                minDiff, r = target-sum, sum
            }
            continue
        }

        left, right := i+1, n-1
        for left < right {
            sum = num + nums[left] + nums[right]
            if sum == target {
                return target
            }

            if sum > target {
                if sum-target < minDiff {
                    minDiff, r = sum-target, sum
                }
                right--
            } else {
                if target-sum < minDiff {
                    minDiff, r = target-sum, sum
                }
                left++
            }
        }
    }

    return r
}
func threeSumClosest0(nums []int, target int) int {
    if len(nums) < 3 {
        return -1
    }

    slices.Sort(nums)
    smallestDiff := 1 << 31

    for i := 0; i < len(nums)-2; i++ {
        left, right := i+1, len(nums)-1
        for left < right {
            diff := target - nums[i] - nums[left] - nums[right]
            if diff == 0 {
                return target
            }
            absDiff, absSmallestDiff := abs(diff), abs(smallestDiff)
            if absDiff < absSmallestDiff || (absDiff == absSmallestDiff && diff > smallestDiff) {
                smallestDiff = diff
            }

            if diff > 0 {
                left++
            } else {
                right--
            }
        }
    }

    return target - smallestDiff
}
func abs(x int) int {
    if x >= 0 {
        return x
    }
    return -x
}

// @lc code=end

func main() {
    array := []int{-1, 2, 1, -4}
    closest := threeSumClosest(array, 1)
    fmt.Println(array, closest)
}
