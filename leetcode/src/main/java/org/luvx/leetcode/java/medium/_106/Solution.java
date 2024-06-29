package org.luvx.leetcode.java.medium._106;
/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.Arrays;

// @lc code=start
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int middle = search(inorder, postorder[postorder.length - 1]);

        int[] bb1 = Arrays.copyOfRange(inorder, 0, middle);
        int[] bb2 = Arrays.copyOfRange(inorder, middle + 1, inorder.length);

        int[] aa1 = Arrays.copyOfRange(postorder, 0, bb1.length);
        int[] aa2 = Arrays.copyOfRange(postorder, bb1.length, postorder.length - 1);

        root.left = buildTree(bb1, aa1);
        root.right = buildTree(bb2, aa2);

        return root;
    }

    public static int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

