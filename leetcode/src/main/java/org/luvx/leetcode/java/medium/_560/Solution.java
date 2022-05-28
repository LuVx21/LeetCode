package org.luvx.leetcode.java.medium._560;
/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] 和为 K 的子数组
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

class Solution {
    /**
     * 1,2,3 - 3 -> 2
     */
    public int subarraySum(int[] nums, int k) {
        // k: 和, v: 个数
        int sum = 0, result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        for (int num : nums) {
            sum += num;
            // 能查到说明到从 0 到当前元素, 一部分和是 sum-k, 一部分和是 k
            Integer cnt = map.getOrDefault(sum - k, 0);
            result += cnt;
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 0, 3};
        Solution exec = new Solution();
        Stream.of(3)
                .map(k -> exec.subarraySum(array, k))
                .forEach(System.out::println);
    }
}
// @lc code=end

