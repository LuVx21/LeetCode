/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
     * 9 5 2 7 9
     * ↓
     * 0 9
     * 0 5 9
     * 0 2 5 9
     * 0 2 5 7 9
     * 0 2 5 7 9 9
     * 稳定
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        ListNode current = head, pre = fakeHead;
        while (current != null) {
            ListNode next = current.next;
            while (pre.next != null && pre.next.val <= current.val) {
                pre = pre.next;
            }
            current.next = pre.next;
            pre.next = current;
            pre = fakeHead;
            current = next;
        }
        return fakeHead.next;
    }

    /**
     * 0 9 5 2 7 9
     * 0 5 9 2 7 9
     * 0 2 5 9 7 9
     * 0 2 5 7 9 9
     */
    public ListNode insertionSortList0(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode current = head, pre = fakeHead;
        while (current != null) {
            ListNode next = current.next;
            ListNode temp = fakeHead.next;
            while (temp != null && temp.next != null) {
                if (temp == current) {
                    pre = current;
                    break;
                }
                if (current.val < temp.val) {
                    pre.next = current.next;
                    current.next = fakeHead.next;
                    fakeHead.next = current;
                    break;
                } else if (temp.val <= current.val && current.val < temp.next.val) {
                    pre.next = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    break;
                }
                temp = temp.next;
            }
            current = next;
        }
        return fakeHead.next;
    }
}

