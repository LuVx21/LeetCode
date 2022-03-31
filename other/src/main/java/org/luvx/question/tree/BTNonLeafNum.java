package org.luvx.question.tree;

import java.util.Stack;

import org.luvx.leetcode.TreeNode;

public class BTNonLeafNum {
    /**
     * 计算二叉树非叶子节点的个数
     *
     * @return 个数
     */
    public static int comNonLeafNums(TreeNode root) {
        if (root == null || root.isLeaf()) {
            return 0;
        }

        int leftNums = comNonLeafNums(root.left);
        int rightNums = comNonLeafNums(root.right);

        return leftNums + rightNums + 1;
    }

    /**
     * 计算二叉树非叶子节点的个数:循环方式
     *
     * @return 个数
     */
    public static int comNonLeafNumsByLoop(TreeNode root) {
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
            if (!root.isLeaf()) {
                nums++;
            }
            root = root.right;
        }

        return nums;
    }
}
