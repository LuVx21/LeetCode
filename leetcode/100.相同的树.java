/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
class Solution {
    /**
     * 递归方式
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 非递归方式
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        Stack<TreeNode> pp = new Stack<>(), qq = new Stack<>();
        pp.push(p);
        qq.push(q);
        while (!pp.isEmpty() && !qq.isEmpty()) {
            TreeNode p1 = pp.pop(), q1 = qq.pop();
            if (p1.val != q1.val) {
                return false;
            }
            if (p1.left != null && q1.left != null) {
                pp.push(p1.left);
                qq.push(q1.left);
            } else if (p1.left == null && q1.left == null) {
            } else {
                return false;
            }

            if (p1.right != null && q1.right != null) {
                pp.push(p1.right);
                qq.push(q1.right);
            } else if (p1.right == null && q1.right == null) {
            } else {
                return false;
            }
        }
        if (!pp.isEmpty() || !qq.isEmpty()) {
            return false;
        }
        return true;
    }
}
// @lc code=end

