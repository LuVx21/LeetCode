package org.luvx.leetcode.java.medium._307;
/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    int[] nums, tree;

    public NumArray(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            init(i, nums[i]);
        }
    }

    void update(int i, int val) {
        init(i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    private void init(int i, int val) {
        for (int j = i + 1; j <= nums.length; j += lowbit(j)) {
            tree[j] += val;
        }
    }

    private int getSum(int i) {
        int sum = 0;
        for (int j = i + 1; j > 0; j -= lowbit(j)) {
            sum += tree[j];
        }
        return sum;
    }

    private int lowbit(int i) {
        return i & -i;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end
