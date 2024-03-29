package org.luvx.leetcode.java.medium._19;

import org.luvx.leetcode.link.ListNode;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(-1, head), slow = start, fast = start;
        for (int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (n == count) {
            return head.next;
        }

        int i = 1;
        temp = head;
        while (true) {
            if (i + n >= count) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
            i++;
        }

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        ListNode current = head, pre = null;
        while (true) {
            int count = 0;
            ListNode temp = current;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            if (count == n) {
                if (pre == null) {
                    return head.next;
                } else {
                    pre.next = current.next;
                    return head;
                }
            }
            pre = current;
            current = current.next;
        }
    }
}
// @lc code=end
