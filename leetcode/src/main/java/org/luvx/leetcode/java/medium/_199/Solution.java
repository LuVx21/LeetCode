package org.luvx.leetcode.java.medium._199;
/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

import org.luvx.leetcode.TreeNode;

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    /**
     * 层次遍历, 每层的最右边一个
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }

    /**
     * 循环方式
     */
    public List<Integer> rightSideView1(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode temp = queue.poll();
                if (queue.isEmpty()) {
                    result.add(temp.val);
                }
                if (temp.left != null) {
                    list.add(temp.left);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }
            }
            queue.addAll(list);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        TreeNode root = TreeNode.of(1,
                TreeNode.of(2, null,
                        TreeNode.of(5)),
                TreeNode.of(3, null,
                        TreeNode.of(4)));
        System.out.println(exec.rightSideView(root));
    }
}
// @lc code=end

