package org.luvx.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ren, Xie
 */
@Slf4j
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    public int      val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode of(int x, TreeNode... lr) {
        final TreeNode root = new TreeNode(x);
        if (lr == null || lr.length == 0) {
            return root;
        }
        root.left = lr[0];
        if (lr.length >= 2) {
            root.right = lr[1];
        }
        return root;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }
}
