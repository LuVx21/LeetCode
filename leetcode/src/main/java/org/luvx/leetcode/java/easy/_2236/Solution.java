package org.luvx.leetcode.java.easy._2236;
/*
 * @lc app=leetcode.cn id=2236 lang=java
 *
 * [2236] 判断根结点是否等于子结点之和
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.val == root.left.val + root.right.val;
    }
}
// @lc code=end
