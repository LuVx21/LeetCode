package org.luvx.question.tree;


import java.util.LinkedList;

import org.luvx.leetcode.tree.TreeNode;

/**
 * 实现计算二叉树的高
 */
public class BTHeight {
    /**
     * 递归方式
     */
    public static int comHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = comHeight(root.left);
        int rightHeight = comHeight(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * 循环方式
     */
    public static int comHeightByLoop(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode head = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index, elementNums;
        int level = 0;

        while (!queue.isEmpty()) {
            index = 0;
            elementNums = queue.size();
            while (index < elementNums) {
                head = queue.poll();
                index++;
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            level++;
        }
        return level;
    }
}
