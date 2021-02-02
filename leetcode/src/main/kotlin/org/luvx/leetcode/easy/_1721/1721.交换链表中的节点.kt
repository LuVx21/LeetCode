package org.luvx.leetcode.easy._1721
/*
 * @lc app=leetcode.cn id=1721 lang=kotlin
 *
 * [1721] 交换链表中的节点
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
     * 给你链表的头节点 head 和一个整数 k。
     * 交换 链表正数第 k 个节点和倒数第 k 个节点的值后，返回链表的头节点（链表 从 1 开始索引）。
     * 1->2->3->4->5 2
     * 1->2->3->4->5
     */
    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var fast = head
        var slow = head
        for (i in 1 until k) {
            fast = fast!!.next
        }
        val first: ListNode? = fast

        while (fast!!.next != null) {
            slow = slow!!.next
            fast = fast.next
        }
        val second: ListNode? = slow

        val temp = first!!.`val`
        first.`val` = second!!.`val`
        second.`val` = temp
        return head
    }
}
// @lc code=end

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    constructor(`val`: Int, next: ListNode?) : this(`val`) {
        this.next = next
    }
}

fun printLink(head: ListNode?) {
    var root = head
    while (root != null) {
        print(root.`val`.toString() + if (root.next == null) "" else "->")
        root = root.next
    }
    println("\n--------------")
}

fun main() {
    val head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5)))))
    val exec = Solution()
    printLink(exec.swapNodes(head, 2))
    printLink(exec.swapNodes(head, 2))
    printLink(exec.swapNodes(head, 4))
}