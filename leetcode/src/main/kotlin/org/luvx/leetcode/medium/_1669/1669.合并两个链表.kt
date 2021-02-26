package org.luvx.leetcode.medium._1669

import org.luvx.leetcode.ListNode
import org.luvx.leetcode.Utils

/*
 * @lc app=leetcode.cn id=1669 lang=kotlin
 *
 * [1669] 合并两个链表
 */

// @lc code=start
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    /**
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将 list2 接在被删除节点的位置。
     * list1 = [0,1,2,3,4,5], a = 3, b = 4,
     * list2 = [1000000,1000001,1000002]
     *
     * 0,1,2,1000000,1000001,1000002,5
     */
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        if (list1 == null) {
            return null
        }
        var pre: ListNode = list1
        var next: ListNode = list1
        for (i in 0..b) {
            if (i < a - 1) {
                pre = pre.next
            }
            next = next.next
        }
        pre.next = list2
        var tail = list2
        while (tail!!.next != null) {
            tail = tail.next
        }
        tail.next = next
        return list1
    }
}
// @lc code=end

fun main() {
    val exec = Solution()
    var list1 = Utils.initLinked(0, 1, 2, 3, 4, 5)
    var list2 = Utils.initLinked(1000000, 1000001, 1000002)
    Utils.printLink(
        exec.mergeInBetween(list1, 3, 4, list2)
    )

    list1 = Utils.initLinked(0, 1, 2, 3, 4, 5, 6)
    list2 = Utils.initLinked(1000000, 1000001, 1000002, 1000003, 1000004)
    Utils.printLink(
        exec.mergeInBetween(list1, 2, 5, list2)
    )
}