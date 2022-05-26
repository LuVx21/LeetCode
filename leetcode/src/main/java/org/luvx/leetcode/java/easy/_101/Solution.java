package org.luvx.leetcode.java.easy._101;

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * </pre>
 */
class Solution {
    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric0(root);
        // return isSymmetric1(root);
    }

    /**
     * 递归
     */
    private boolean isSymmetric0(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    /**
     * 循环
     */
    private boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        if (root.left != null) {
            if (root.right == null) {
                return false;
            }
            stack.push(root.left);
            stack.push(root.right);
        } else if (root.right != null) {
            return false;
        }

        TreeNode left, right;
        while (!stack.empty()) {
            if (stack.size() % 2 != 0) {
                return false;
            }
            right = stack.pop();
            left = stack.pop();
            if (right.val != left.val) {
                return false;
            }

            if (left.left != null) {
                if (right.right == null) {
                    return false;
                }
                stack.push(left.left);
                stack.push(right.right);
            } else if (right.right != null) {
                return false;
            }

            if (left.right != null) {
                if (right.left == null) {
                    return false;
                }
                stack.push(left.right);
                stack.push(right.left);
            } else if (right.left != null) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

