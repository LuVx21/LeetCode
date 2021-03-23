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

    public static TreeNode of(int x, TreeNode left, TreeNode right) {
        return new TreeNode(x, left, right);
    }
}
