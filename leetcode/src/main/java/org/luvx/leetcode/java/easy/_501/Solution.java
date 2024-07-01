package org.luvx.leetcode.java.easy._501;
/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private int currentVal;
    private int currentCount = 0;
    private int maxCount     = 0;

    private final List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        inOrderTraversal(root.left);

        currentCount = (root.val == currentVal) ? currentCount + 1 : 1;
        if (currentCount == maxCount) {
            modes.add(root.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(root.val);
        }
        currentVal = root.val;

        inOrderTraversal(root.right);
    }
}
// @lc code=end
