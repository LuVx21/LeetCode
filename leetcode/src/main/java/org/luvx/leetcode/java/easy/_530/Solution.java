package org.luvx.leetcode.java.easy._530;
/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

import org.luvx.leetcode.tree.TreeNode;

// @lc code=start
class Solution {
    int min  = Integer.MAX_VALUE;
    int prev = -1;

    /**
     * 和No.783相同
     */
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        getMinimumDifference(root.left);

        if (prev != -1) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);
        return min;
    }
}
// @lc code=end
