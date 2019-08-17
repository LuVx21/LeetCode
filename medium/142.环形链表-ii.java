/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode current = head, pre = null;
        while (current != null) {
            ListNode pre1 = head;
            while (pre1 != current) {
                if (pre1.next == current && pre1 != pre) {
                    return current;
                }
                pre1 = pre1.next;
            }
            pre = current;
            current = current.next;
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}

