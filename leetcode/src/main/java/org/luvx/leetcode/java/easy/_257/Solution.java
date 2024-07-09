package org.luvx.leetcode.java.easy._257;
/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

import org.luvx.leetcode.tree.TreeNode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
class Solution {
    /**
     * 一种有意思的思想
     */
    public List<String> binaryTreePaths(TreeNode root) {
        return new AbstractList<String>() {
            private final List<String>  list = new ArrayList<>();
            private final StringBuilder sb   = new StringBuilder();

            @Override
            public String get(int index) {
                init();
                return list.get(index);
            }

            @Override
            public int size() {
                init();
                return list.size();
            }

            void init() {
                if (list.isEmpty()) {
                    if (root == null) {
                        return;
                    }
                    sb.append(root.val);
                    traverseNode(root);
                }
            }

            void traverseNode(TreeNode tree) {
                boolean isLeaf = true;
                if (tree.left != null) {
                    isLeaf = false;
                    writePath(tree.left);
                }
                if (tree.right != null) {
                    isLeaf = false;
                    writePath(tree.right);
                }
                if (isLeaf) {
                    list.add(sb.toString());
                }
            }

            void writePath(TreeNode tree) {
                int originalLen = sb.length();
                sb.append("->").append(tree.val);
                traverseNode(tree);
                sb.setLength(originalLen);
            }
        };
    }

    /**
     * 1ms
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root, new StringBuilder().append(root.val), list);
        return list;
    }

    void dfs(TreeNode root, StringBuilder sb, List<String> res) {
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
            return;
        }
        int n = sb.length();
        if (root.left != null) {
            dfs(root.left, sb.append("->").append(root.left.val), res);
            sb.delete(n, sb.length());
        }
        if (root.right != null) {
            dfs(root.right, sb.append("->").append(root.right.val), res);
            sb.delete(n, sb.length());
        }
    }

    /**
     * 慢:2ms
     */
    public List<String> binaryTreePaths0(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        if (root.left == null && root.right == null) {
            return Collections.singletonList(String.valueOf(root.val));
        }
        List<String> dfs = binaryTreePaths0(root.left), dfs1 = binaryTreePaths0(root.right);
        List<String> list = new ArrayList<>(dfs.size() + dfs1.size());
        for (String df : dfs) {
            list.add(new StringBuilder().append(root.val).append("->").append(df).toString());
        }
        for (String df : dfs1) {
            list.add(new StringBuilder().append(root.val).append("->").append(df).toString());
        }
        return list;
    }
}
// @lc code=end

