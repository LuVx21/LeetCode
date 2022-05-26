package org.luvx.leetcode.tree;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    public static Node of(int val) {
        return new Node(val);
    }

    public static Node of(int val, Node... nodes) {
        return new Node(val, Lists.newArrayList(nodes));
    }
}
