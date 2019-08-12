/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 描述有很大问题
     * 1. 删除哪个节点
     * 2. 在哪里删
     * 3. node节点是什么
     * 官方题解给的也不是删除node,从链表上脱离的也是node.next
     * 在脱离前node的值变成node.next的值
     * 变相的相当于删除node, 实际只是改了node的值
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

