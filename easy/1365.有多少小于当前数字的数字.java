/*
 * @lc app=leetcode.cn id=1365 lang=java
 *
 * [1365] 有多少小于当前数字的数字
 */

// @lc code=start
class Solution {
    /**
     * 创建大小为 101 的数组,
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] array = new int[101];
        for (int i : nums) {
            array[i] = array[i] + 1;
        }

        int length = nums.length;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int count = 0;
            for (int j = nums[i] - 1; j >= 0; j--) {
                count += array[j];
            }
            result[i] = count;
        }
        return result;
    }
}
// @lc code=end

