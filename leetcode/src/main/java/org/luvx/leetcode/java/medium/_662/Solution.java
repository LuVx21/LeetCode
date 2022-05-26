package org.luvx.leetcode.java.medium._662;
/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
 */

import org.luvx.leetcode.tree.TreeNode;
// @lc code=start
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    /**
     * 每个节点按照满二叉树标号, 每层的宽度就是最右的号码减去最左号码后加一
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        queue.offer(root);
        map.put(root, 1);

        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    start = map.get(node);
                }
                if (i == size - 1) {
                    end = map.get(node);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    map.put(node.left, map.get(node) * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.put(node.right, map.get(node) * 2 + 1);
                }
            }
            result = Math.max(end - start + 1, result);
        }
        return result;
    }

    public int widthOfBinaryTree2(TreeNode root) {
        Queue<SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new SimpleEntry<>(root, 0));

        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            SimpleEntry<TreeNode, Integer> head = queue.peek(), tail = head;
            for (int i = size; i > 0; i--) {
                tail = queue.poll();
                TreeNode node = tail.getKey();
                int index = tail.getValue();
                if (node.left != null) {
                    queue.add(new SimpleEntry<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.add(new SimpleEntry<>(node.right, 2 * index + 1));
                }
            }
            result = Math.max(tail.getValue() - head.getValue() + 1, result);
        }
        return result;
    }
}
// @lc code=end

