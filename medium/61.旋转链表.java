/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode fast = fakeHead, slow = fakeHead;

        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = fakeHead.next;
        fakeHead.next = slow.next;
        slow.next = null;

        return fakeHead.next;
    }

    public ListNode rotateRight0(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode current = head, tail = null;
        int count = 0;
        while (true) {
            count++;
            if (current.next == null) {
                tail = current;
                tail.next = head;
                break;
            }
            current = current.next;
        }
        if (k == count) {
            tail.next = null;
            return head;
        }
        k = k < count ? k : k % count;
        count = count - k;
        current = head;
        while (true) {
            if (count == 1) {
                ListNode next = current.next;
                current.next = null;
                return next;
            }
            current = current.next;
            count--;
        }
    }
}

