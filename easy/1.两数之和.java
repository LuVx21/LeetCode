/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
        // int length = nums.length;
        // for (int i = 0; i < length; i++) {
        //     for (int j = i + 1; j < length; j++) {
        //         if (target - nums[i] == nums[j]) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return null;
    }
}

