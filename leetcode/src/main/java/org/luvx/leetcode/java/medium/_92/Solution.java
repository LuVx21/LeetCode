package org.luvx.leetcode.java.medium._92;
/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

import org.luvx.leetcode.link.ListNode;

// @lc code=start
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right == left) {
            return head;
        }
        ListNode temp = new ListNode(0), pre = temp;
        temp.next = head;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        ListNode current = pre.next, next = current.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextNext = next.next;
            current.next = nextNext;
            next.next = pre.next;
            pre.next = next;
            next = nextNext;
        }

        return temp.next;
    }

    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (n == m) {
            return head;
        }
        int i = 1;
        ListNode pre = head;
        ListNode current = head;
        ListNode[] array = null;
        while (current != null) {
            if (i == m) {
                array = reverseList(current, n - m + 1);
                if (m == 1) {
                    head = array[0];
                } else {
                    pre.next = array[0];
                }
                break;
            }
            pre = current;
            current = current.next;
            i++;
        }
        return head;
    }

    public ListNode[] reverseList(ListNode head, int cnt) {
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode current = head.next;
        head.next = null;
        int i = 1;
        while (head != null && current != null && i < cnt) {
            ListNode nextNext = current.next;
            current.next = head;
            head = current;
            current = nextNext;
            tail.next = current;
            i++;
        }
        ListNode[] array = {head, tail};
        return array;
    }
}
// @lc code=end

