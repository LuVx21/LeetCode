package org.luvx.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * N叉树
 *
 * @author Ren, Xie
 */
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    public int        val;
    public List<Node> children;

    public Node(int val) {
        this.val = val;
    }
}
