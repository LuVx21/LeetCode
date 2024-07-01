package org.luvx.remember.tree;

import org.luvx.leetcode.tree.TreeNode;
import org.luvx.leetcode.util.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 二叉搜索树迭代器
 * 关联: No.173
 */
public class BSTIterator {
    final boolean         flag;
    final Deque<TreeNode> stack;

    /**
     * @param flag true: 正序, false: 逆序
     */
    public BSTIterator(boolean flag, TreeNode root) {
        this.flag = flag;
        this.stack = new ArrayDeque<>();
        if (root != null) {
            pushAll(root);
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        pushAll(flag ? pop.right : pop.left);
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = flag ? root.left : root.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.buildCBT(7, 3, 15, null, null, 9, 20);
        BSTIterator it = new BSTIterator(false, root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
