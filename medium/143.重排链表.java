/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            if (fast == null) {
                slow.next = null;
            }
            slow = next;
            if (fast != null && fast.next == null) {
                ListNode next1 = slow.next;
                slow.next = null;
                slow = next1;
            }
        }
        slow = reverse(slow);
        fast = head;
        ListNode temp = slow;
        while (temp != null) {
            ListNode fastNext = fast.next;
            ListNode slowNext = slow.next;
            head.next = temp;
            head = head.next;
            if (temp == fast) {
                temp = slowNext;
                slow = temp;
            } else {
                temp = fastNext;
                fast = temp;
            }
        }
    }

    // 反转链表:参见206题
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

