package org.luvx.leetcode.java.medium._230;
/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.Stack;

// @lc code=start
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    int result;
    int k;

    public int kthSmallest2(TreeNode root, int k) {
        this.k = k;
        midSearch(root);
        return result;
    }

    private void midSearch(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        midSearch(root.left);
        if (--k == 0) {
            result = root.val;
        }
        midSearch(root.right);
    }
}
// @lc code=end
