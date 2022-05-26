package org.luvx.leetcode.java.easy._637;

import org.luvx.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// @lc code=start
/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
 */

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
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
     * <pre>
     *          5
     *         / \
     *        4   8
     *       /   / \
     *      11  13  4
     *     /  \      \
     *    7    2      1
     * </pre>
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double size = queue.size(), sum = 0;
            TreeNode temp;
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                sum += temp.val;
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }

    public List<Double> averageOfLevels1(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp;
        int cnt = 1, nowCnt = 1, nextCnt = 0;
        double sum = 0.0;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            sum += temp.val;
            cnt--;
            if (temp.left != null) {
                queue.add(temp.left);
                nextCnt++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                nextCnt++;
            }
            if (cnt == 0) {
                result.add(sum / nowCnt);
                nowCnt = cnt = nextCnt;
                sum = 0.0;
                nextCnt = 0;
            }
        }
        return result;
    }
}
// @lc code=end

