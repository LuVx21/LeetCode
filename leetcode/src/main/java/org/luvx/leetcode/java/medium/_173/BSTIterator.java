package org.luvx.leetcode.java.medium._173;
/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */

import org.luvx.leetcode.tree.TreeNode;
import org.luvx.leetcode.util.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

// @lc code=start
class BSTIterator {
    final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        if (root != null) {
            pushAll(root);
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        pushAll(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildCBT(7, 3, 15, null, null, 9, 20);
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
