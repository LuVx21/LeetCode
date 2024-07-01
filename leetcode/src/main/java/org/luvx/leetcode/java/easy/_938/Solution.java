package org.luvx.leetcode.java.easy._938;
/*
 * @lc app=leetcode.cn id=938 lang=java
 *
 * [938] 二叉搜索树的范围和
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val > low) {
            sum += rangeSumBST(root.left, low, high);
        }
        if (root.val < high) {
            sum += rangeSumBST(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int v = low <= root.val && root.val <= high ? root.val : 0;
        return v + rangeSumBST2(root.right, low, high) + rangeSumBST2(root.left, low, high);
    }

    public int rangeSumBST1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST1(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST1(root.left, low, high);
        }
        return root.val + rangeSumBST1(root.left, low, high) + rangeSumBST1(root.right, low, high);
    }
}
// @lc code=end
