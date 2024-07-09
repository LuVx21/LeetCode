package org.luvx.leetcode.java.easy._110;
/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return high(root) != -1;
    }

    int high(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = high(root.left), rh = high(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}
// @lc code=end
