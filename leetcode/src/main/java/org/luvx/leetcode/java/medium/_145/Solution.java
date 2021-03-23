package org.luvx.leetcode.java.medium._145;

import org.luvx.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// @lc code=start
/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (stack.isEmpty()) {
                return result;
            }

            if (stack.lastElement().right == null) {
                root = stack.pop();
                result.add(root.val);
                while (!stack.isEmpty() && root == stack.lastElement().right) {
                    root = stack.pop();
                    result.add(root.val);
                }
            }

            root = !stack.isEmpty() ? stack.lastElement().right : null;
        }
    }
}
// @lc code=end

