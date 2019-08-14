/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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

