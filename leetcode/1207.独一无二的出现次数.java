/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start
import java.util.*;
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] c = new int[2001];
        for (int n : arr) {
            c[n + 1000]++;
        }
        Set<Integer> set = new HashSet<>(arr.length);
        for (int count : c) {
            if (count == 0) {
                continue;
            }
            if (!set.add(count)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences0(int[] arr) {
        int len = arr.length;
        Map<Integer, Integer> map = new HashMap<>(len);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Collection<Integer> values = map.values();
        Set<Integer> set = new HashSet<>(values);
        return set.size() == values.size();
    }
}
// @lc code=end

