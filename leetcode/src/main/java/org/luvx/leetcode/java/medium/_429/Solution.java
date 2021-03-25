package org.luvx.leetcode.java.medium._429;

import org.luvx.leetcode.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// @lc code=start
/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            Node temp;
            LinkedList<Integer> row = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                temp = queue.poll();
                row.add(temp.val);
                final List<Node> children = temp.children;
                if (children == null) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result.add(row);
        }
        return result;
    }
}
// @lc code=end
