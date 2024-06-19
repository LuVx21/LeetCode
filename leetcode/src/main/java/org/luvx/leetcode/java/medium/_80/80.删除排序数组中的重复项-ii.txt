/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        final int keepCnt = 2;
        int index = 0;
        for (int n : nums) {
            if (index < keepCnt || n > nums[index - keepCnt]) {
                nums[index++] = n;
            }
        }
        return index;
    }
}
