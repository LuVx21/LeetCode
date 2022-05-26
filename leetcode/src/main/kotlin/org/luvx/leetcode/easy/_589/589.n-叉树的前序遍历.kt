package org.luvx.leetcode.easy._589

import org.luvx.leetcode.tree.Node
/*
 * @lc app=leetcode.cn id=589 lang=kotlin
 *
 * [589] N 叉树的前序遍历
 */
/**
 * Definition for a Node.
 * <pre>
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 * </pre>
 */
// @lc code=start
import java.util.*

class Solution {
    fun preorder(root: Node?): List<Int> {
        return loop(root)
        // return digui(root)
    }

    /**
     * <pre>
     * 1
     * /|\
     * 3 2 4
     * /\
     * 5 6
    </pre> *
     */
    fun loop(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result: MutableList<Int> = ArrayList()
        val stack = Stack<Node>()
        stack.add(root)
        while (!stack.empty()) {
            val temp = stack.pop()
            result.add(temp.`val`)
            if (temp.children != null) {
                for (i in temp.children.indices.reversed()) {
                    stack.add(temp.children[i])
                }
            }
        }
        return result
    }

    fun digui(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result: MutableList<Int> = ArrayList()
        result.add(root.`val`)
        if (root.children != null) {
            for (child in root.children) {
                result.addAll(digui(child))
            }
        }
        return result
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    val root = Node.of(
        1,
        Node.of(
            3,
            Node.of(5),
            Node.of(6)
        ),
        Node.of(2),
        Node.of(4)
    )
    val root1 = Node.of(
        1,
        Node.of(2),
        Node.of(
            3,
            Node.of(6),
            Node.of(
                7,
                Node.of(
                    11,
                    Node.of(14)
                )
            )
        ),
        Node.of(
            4,
            Node.of(
                8,
                Node.of(12)
            )
        ),
        Node.of(
            5,
            Node.of(
                9,
                Node.of(13)
            ),
            Node.of(10)
        )
    )

    arrayOf(root, root1)
        .map(exec::preorder)
        .forEach(::println)
}
