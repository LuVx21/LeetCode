package org.luvx.leetcode.java.medium._1008;
/*
 * @lc app=leetcode.cn id=1008 lang=java
 *
 * [1008] 前序遍历构造二叉搜索树
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int lowerBound, int upperBound) {
        if (index == preorder.length) {
            return null;
        }

        int cur = preorder[index];
        if (cur < lowerBound || cur > upperBound) {
            return null;
        }

        index++;
        TreeNode root = new TreeNode(cur);
        root.left = dfs(preorder, lowerBound, cur);
        root.right = dfs(preorder, cur, upperBound);
        return root;
    }

    /**
     *
     */
    public TreeNode bstFromPreorder0(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; ++i) {
            insert(preorder[i], root);
        }
        return root;
    }

    private void insert(int val, TreeNode root) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insert(val, root.left);
            }
            return;
        }
        if (root.right == null) {
            root.right = new TreeNode(val);
        } else {
            insert(val, root.right);
        }
    }
}
// @lc code=end

