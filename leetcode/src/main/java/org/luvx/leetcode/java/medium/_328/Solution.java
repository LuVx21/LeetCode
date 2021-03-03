package org.luvx.leetcode.java.medium._328;

import org.luvx.leetcode.ListNode;

/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * <pre>
 *      public class ListNode {
 *          int val;
 *          ListNode next;
 *          ListNode() {}
 *          ListNode(int val) { this.val = val; }
 *          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 *      }
 * </pre>
 */
class Solution {
    /**
     * 1 -> 2 -> 3 -> 4 -> 5
     * 1 -> 3    2 -> 4 -> 5
     * 1 -> 3 -> 5    2 -> 4
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, current = head.next, even = head.next;
        while (current != null && current.next != null) {
            odd = odd.next = current.next;
            current = current.next = odd.next;
        }
        odd.next = even;
        return head;
    }

    public ListNode oddEvenList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode even = new ListNode(0);
        ListNode temp = even;
        ListNode odd = head;
        while (odd != null && odd.next != null) {
            ListNode next = odd.next;
            ListNode nextNext = next.next;
            odd.next = nextNext;
            next.next = null;
            temp.next = next;
            if (nextNext != null) {
                odd = nextNext;
            }
            temp = temp.next;
        }

        odd.next = even.next;
        return head;
    }

    // 1,2,3,4,5
    // 1,3,2,4,5
    // 1,3,5,2,4
    public ListNode oddEvenList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode current = pre.next;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            ListNode nextNext = next.next;
            next.next = pre.next;
            pre.next = next;
            current.next = nextNext;

            pre = pre.next;
            current = nextNext;
        }
        return head;
    }
}
// @lc code=end

