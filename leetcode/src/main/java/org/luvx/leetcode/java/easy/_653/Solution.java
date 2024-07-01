package org.luvx.leetcode.java.easy._653;
/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入二叉搜索树
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {

    /**
     * <img src="https://assets.leetcode.com/uploads/2020/09/21/sum_tree_1.jpg"></img>
     */
    public boolean findTarget(TreeNode root, int k) {
        TreeNode left = root, right = root;
        Deque<TreeNode> leftStack = new ArrayDeque<>(), rightStack = new ArrayDeque<>();
        leftStack.push(left);
        rightStack.push(right);

        while (left.left != null) {
            leftStack.push(left.left);
            left = left.left;
        }
        while (right.right != null) {
            rightStack.push(right.right);
            right = right.right;
        }

        while (left != right) {
            int v = left.val + right.val;
            if (v == k) {
                return true;
            }
            if (v < k) {
                left = next(leftStack, true);
            } else {
                right = next(rightStack, false);
            }
        }
        return false;
    }

    private TreeNode next(Deque<TreeNode> stack, boolean flag) {
        TreeNode next = stack.pop(), cur = flag ? next.right : next.left;
        while (cur != null) {
            stack.push(cur);
            cur = flag ? cur.left : cur.right;
        }
        return next;
    }

    final Set<Integer> res = new HashSet<>();

    public boolean findTarget1(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (res.contains(k - root.val)) {
            return true;
        }
        res.add(root.val);
        return findTarget1(root.left, k) || findTarget1(root.right, k);
    }
}
// @lc code=end
