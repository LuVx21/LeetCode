package org.luvx.leetcode.java.medium._105;
/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.Arrays;

// @lc code=start
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int middle = search(inorder, preorder[0]);

        int[] bb1 = Arrays.copyOfRange(inorder, 0, middle);
        int[] bb2 = Arrays.copyOfRange(inorder, middle + 1, inorder.length);

        int[] aa1 = Arrays.copyOfRange(preorder, 1, bb1.length + 1);
        int[] aa2 = Arrays.copyOfRange(preorder, 1 + bb1.length, preorder.length);

        root.left = buildTree(aa1, bb1);
        root.right = buildTree(aa2, bb2);

        return root;
    }

    public int search(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

