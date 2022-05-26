package org.luvx.leetcode.easy._590

import org.luvx.leetcode.tree.Node

/*
 * @lc app=leetcode.cn id=590 lang=kotlin
 *
 * [590] N 叉树的后序遍历
 */

// @lc code=start
import java.util.*

class Solution {
    fun postorder(root: Node?): List<Int> {
        return loop(root)
        // return digui(root)
    }

    fun loop(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result: MutableList<Int> = ArrayList()
        val stack = Stack<Node>()
        stack.add(root)
        while (!stack.isEmpty()) {
            val temp = stack.pop()
            result.add(temp.`val`)
            if (temp.children != null) {
                for (child in temp.children) {
                    stack.add(child)
                }
            }
        }
        result.reverse()
        return result
    }

    fun digui(root: Node?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val result: MutableList<Int> = ArrayList()
        if (root.children != null) {
            for (child in root.children) {
                result.addAll(digui(child))
            }
        }
        result.add(root.`val`)
        return result
    }
}
// @lc code=end
