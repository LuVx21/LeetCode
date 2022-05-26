package org.luvx.leetcode.java.easy._112;

import org.luvx.leetcode.tree.TreeNode;

import java.util.Stack;
// @lc code=start
/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。
 * <p>
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
class Solution {
    /**
     *中序遍历
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        int sum1 = 0;
        while (true) {
            while (root != null) {
                stack.push(root);
                sum1 += root.val;
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            if (root.left == null && root.right == null) {
                if (sum1 == sum) {
                    return true;
                }
                sum1 -= root.val;
            } else {
                if (root.right == null) {
                    sum1 -= root.val;
                }
            }
            root = root.right;
        }
        return false;
    }

    /**
     * <pre>
     *          5
     *         / \
     *        4   8
     *       /   / \
     *      11  13  4
     *     /  \      \
     *    7    2      1
     * </pre>
     */
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum1(root.left, sum - root.val)
                || hasPathSum1(root.right, sum - root.val);
    }
}
// @lc code=end

