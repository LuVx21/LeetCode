package org.luvx.remember.tree;

import org.luvx.leetcode.TreeNode;

/**
 * 二叉搜索树
 */
public class BinSearchTree {
    /**
     * 递归实现
     *
     * @param root 根节点
     * @param obj  查找值
     */
    public static void search(TreeNode root, Integer obj) {
        if (root == null)
            return;
        if (root.val == obj) {
            System.out.println("OK");
        } else if (obj < root.val) {
            System.out.println("左子树......");
            search(root.left, obj);
        } else {
            System.out.println("右子树......");
            search(root.right, obj);
        }
    }
}
