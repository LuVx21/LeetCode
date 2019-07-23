/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] < nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

    public int removeDuplicates1(int[] nums) {
        final int keepCnt = 1;
        int index = 0;
        for (int n : nums) {
            if (index < keepCnt || n > nums[index - keepCnt]) {
                nums[index++] = n;
            }
        }
        return index;
    }
}
