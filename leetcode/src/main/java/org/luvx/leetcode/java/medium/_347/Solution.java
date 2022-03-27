package org.luvx.leetcode.java.medium._347;
/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */
// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    /**
     * 1,1,1,2,2,3
     * 1. 计算出现频率
     * 2. 按照频率确定槽位, 存储数组元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey(), frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (Integer e : bucket[i]) {
                result[index++] = e;
                if (index >= k) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 优先级队列
     */
    public int[] topKFrequent1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Set<Entry<Integer, Integer>> entries = map.entrySet();
        // 根据map的value值正序排，相当于一个小顶堆
        Queue<Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        int[] array = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(exec.topKFrequent(array, 2)));
    }
}
// @lc code=end

