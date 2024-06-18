package org.luvx.leetcode.java.medium._24;
/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

import org.luvx.leetcode.link.ListNode;
// @lc code=start

/**
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 */
class Solution {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * 示例:
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = head.next;
        ListNode nextCouple = head, pre = null;
        while (nextCouple != null && nextCouple.next != null) {
            ListNode next = nextCouple.next;
            nextCouple.next = next.next;
            next.next = nextCouple;
            if (pre != null) {
                pre.next = next;
            }
            pre = nextCouple;
            nextCouple = nextCouple.next;
        }

        return result;
    }

    public ListNode swapPairs0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead, nextCouple = head;
        while (nextCouple != null && nextCouple.next != null) {
            ListNode next = nextCouple.next;
            nextCouple.next = next.next;
            next.next = nextCouple;
            pre.next = next;
            pre = nextCouple;
            nextCouple = nextCouple.next;
        }
        return fakeHead.next;
    }
}
// @lc code=end

