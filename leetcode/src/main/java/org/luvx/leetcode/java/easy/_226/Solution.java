package org.luvx.leetcode.java.easy._226;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode parent = queue.poll();
            TreeNode temp = parent.right;
            parent.right = parent.left;
            parent.left = temp;

            if (parent.left != null) {
                queue.offer(parent.left);
            }
            if (parent.right != null) {
                queue.offer(parent.right);
            }
        }
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }
}
// @lc code=end
