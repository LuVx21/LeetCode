package org.luvx.leetcode.java.easy._111;
/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

// @lc code=start
class Solution {
    /**
     * <img src="https://assets.leetcode.com/uploads/2020/10/12/ex_depth.jpg"></img>
     * 层次遍历, 每层加1
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);

        int min = 1;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return min;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            min++;
        }
        return min;
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = minDepth(root.left), rh = minDepth(root.right);
        return (lh == 0 || rh == 0) ? lh + rh + 1 : 1 + Math.min(lh, rh);
    }
}
// @lc code=end
