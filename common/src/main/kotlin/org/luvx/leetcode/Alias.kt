package org.luvx.leetcode

public typealias ListNodeKt = ListNode
public typealias TreeKt = TreeNode

fun Any.out(vararg messages: Any?) {
    println(this)
    if (messages.isNotEmpty()) {
        println("-----------------")
        for (message in messages) {
            println(message)
        }
    }
}