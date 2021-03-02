package org.luvx.question

import org.luvx.leetcode.ListNode
import org.luvx.leetcode.Utils
import java.util.*

/**
 * 单词以链表形式存储, 当存在相同后缀时, 找到后缀的起始位置
 * http://c.biancheng.net/cpp/html/2698.html
 *
 * loading - being -> ing
 * leading - being -> ing
 * leading - ending -> ding
 * 栈
 * 双指针:
 */
fun wordLink(n1: ListNode, n2: ListNode): ListNode? {
    val s1 = Stack<ListNode>()
    val s2 = Stack<ListNode>()
    var h1: ListNode? = n1
    var h2: ListNode? = n2
    while (h1 != null) {
        s1.push(h1)
        h1 = h1.next
    }
    while (h2 != null) {
        s2.push(h2)
        h2 = h2.next
    }

    var root: ListNode? = null
    while (!s1.empty() && !s1.empty()) {
        h1 = s1.pop()
        h2 = s2.pop()
        if (h1 !== h2) {
            return root
        }
        root = h1
    }

    return root
}

fun wordLink1(n1: ListNode, n2: ListNode): ListNode? {
    val l1 = cnt(n1)
    val l2 = cnt(n2)
    var h1: ListNode? = n1
    var h2: ListNode? = n2
    for (i in 1..l1 + l2) {
        if (h1 == null) {
            h1 = n2
        }
        if (h2 == null) {
            h2 = n1
        }
        if (h1 === h2) {
            return h1
        }
        h1 = h1.next
        h2 = h2.next
    }
    return null
}

fun wordLink2(n1: ListNode, n2: ListNode): ListNode? {
    var l1 = cnt(n1)
    var l2 = cnt(n2)
    var h1: ListNode = n1
    var h2: ListNode = n2
    while (l1 > l2) {
        h1 = h1.next
        l1--
    }
    while (l2 > l1) {
        h2 = h2.next
        l2--
    }
    while (h1.next !== null && h1.next !== h2.next) {
        h1 = h1.next
        h2 = h2.next
    }
    return h1.next
}

fun cnt(head: ListNode?): Int {
    var root = head
    var cnt = 0
    while (root != null) {
        cnt++
        root = root.next
    }
    return cnt
}

fun main() {
    val l1 = Utils.initLinked(1, 2, 3, 4, 5, 6, 7)
    val l2 = Utils.initLinked(11, 12, 13, 14, 15, 16, 17)
    val next = ListNode(8, null)
    l1.next = next
    l2.next = next
    Utils.printLink(
        wordLink2(l1, l2)
    )
}
