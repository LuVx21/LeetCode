package org.luvx.leetcode.java.hard._23;

import org.luvx.leetcode.ListNode;

// @lc code=start
/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */

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
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * offer操作兼具根据头节点排序链表的作用
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode fakeHead = new ListNode(0), current = fakeHead;
        while (!queue.isEmpty()) {
            current.next = queue.poll();
            current = current.next;
            if (current.next != null) {
                queue.offer(current.next);
            }
        }
        return fakeHead.next;
    }

    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        int length = lists.length;
        if (length == 0) {
            return null;
        }
        while (length > 1) {
            for (int i = 0; i <= length / 2; i++) {
                if (i >= length - 1 - i) {
                    break;
                }
                lists[i] = merge(lists[i], lists[length - 1 - i]);
            }
            length = (length + 1) / 2;
        }
        return lists[0];
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == head2) {
            return head1;
        }
        ListNode fakeHead = new ListNode(0), current = fakeHead;
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
        return fakeHead.next;
    }
}
// @lc code=end

