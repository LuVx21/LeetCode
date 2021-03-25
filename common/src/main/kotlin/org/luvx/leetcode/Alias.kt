package org.luvx.leetcode

typealias ListNodeKt = ListNode
typealias TreeKt = TreeNode
typealias NTreeNode = Node

fun Any?.out(vararg messages: Any?): Any? {
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