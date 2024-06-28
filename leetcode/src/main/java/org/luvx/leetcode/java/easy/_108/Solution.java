package org.luvx.leetcode.java.easy._108;
/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return tree(nums, 0, nums.length - 1);
    }

    private TreeNode tree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int i = left + (right - left) / 2;
        if (i < 0 || i >= nums.length) {
            return null;
        }

        TreeNode root = new TreeNode(nums[i]);
        root.left = tree(nums, left, i - 1);
        root.right = tree(nums, i + 1, right);
        return root;
    }
}
// @lc code=end
