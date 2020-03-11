/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    // 异或的特点: 相同为0, 不同为1
    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
        // Map<Integer, Integer> map = new HashMap<>((nums.length - 1) / 2 + 1);

        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        // }
        // Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        // for (Map.Entry<Integer, Integer> entry : set) {
        //     if (entry.getValue() == 1) {
        //         return entry.getKey();
        //     }
        // }

        // throw new RuntimeException("不存在这样的数");
    }
}
// @lc code=end

