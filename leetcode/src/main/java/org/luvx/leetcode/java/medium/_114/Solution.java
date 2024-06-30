package org.luvx.leetcode.java.medium._114;
/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode left = root.left, right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
// @lc code=end
