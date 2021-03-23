package org.luvx.leetcode

public typealias ListNodeKt = ListNode
public typealias TreeKt = TreeNode

fun Any.out(vararg messages: Any?): Any {
    println(this)
    if (messages.isNotEmpty()) {
        println("-----------------")
        println(messages.contentDeepToString())
    }
    return this
}

fun out(vararg messages: Any?) {
    println(messages.contentDeepToString())
}