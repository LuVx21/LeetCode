package org.luvx.leetcode.java.medium._102;

import org.luvx.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// @lc code=start
/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 */

/**
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * </pre>
 */
class Solution {
    /**
     *
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode temp;
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                row.add((temp.val));
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(row);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        int cnt = 1, nextCnt = 0;
        List<Integer> l = new ArrayList<>();
        while (!queue.isEmpty()) {
            temp = queue.poll();
            l.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
                nextCnt++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextCnt++;
            }
            cnt--;
            if (cnt == 0) {
                result.add(l);
                l = new ArrayList<>();
                cnt = nextCnt;
                nextCnt = 0;
            }
        }
        return result;
    }
}
// @lc code=end
