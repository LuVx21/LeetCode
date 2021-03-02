package org.luvx.leetcode.java.easy._1636;
/*
 * @lc app=leetcode.cn id=1636 lang=java
 *
 * [1636] 按照频率将数组升序排序
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        return Arrays.stream(nums)
                .boxed()
                .sorted(
                        (a, b) -> map.get(a).equals(map.get(b)) ? b - a : map.get(a) - map.get(b)
                )
                .mapToInt(n -> n)
                .toArray();
    }
}
// @lc code=end

