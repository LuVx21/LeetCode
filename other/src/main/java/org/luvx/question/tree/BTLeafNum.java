package org.luvx.question.tree;

import java.util.Stack;

import org.luvx.leetcode.tree.TreeNode;

public class BTLeafNum {
    /**
     * 计算二叉树叶子节点的个数
     *
     * @return 个数
     */
    public static int comLeafNums(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.isLeaf()) {
            return 1;
        }

        int leftNums = comLeafNums(root.left);
        int rightNums = comLeafNums(root.right);

        return leftNums + rightNums;
    }

    /**
     * 计算二叉树叶子节点的个数:循环方式
     *
     * @return 个数
     */
    public static int comLeafNumsByLoop(TreeNode root) {
        int nums = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            if (root.isLeaf()) {
                nums++;
            }
            root = root.right;
        }

        return nums;
    }
}
