package org.luvx.leetcode.java.medium._148;
/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
     * 归并排序版本
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;// 长链表拆成2个短链表
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(slow);
        return merge(head1, head2);
    }

    ListNode merge(ListNode head1, ListNode head2) {
        ListNode temp = new ListNode(0), current = temp;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) {
            current.next = head1;
        }
        if (head2 != null) {
            current.next = head2;
        }
        return temp.next;
    }

    // 不符合时间复杂度的冒泡排序版本
    public ListNode sortList1(ListNode head) {
        int count = LinkedCount(head);
        for (int i = 0; i < count; i++) {
            ListNode current = head;
            ListNode pre = null;
            boolean isSort = true;
            while (current != null) {
                ListNode next = current.next;
                if (next == null) {
                    break;
                }
                if (current.val > next.val) {
                    current.next = next.next;
                    next.next = current;
                    if (pre != null) {
                        pre.next = next;
                    }
                    pre = next;
                    if (current == head) {
                        head = next;
                    }
                    isSort = false;
                } else {
                    pre = current;
                    current = next;
                }
            }
            if (isSort) {
                break;
            }
        }
        return head;
    }

    public static int LinkedCount(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
// @lc code=end

