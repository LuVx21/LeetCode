package org.luvx.leetcode.java.easy._104;
/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
// @lc code=end
