package org.luvx.leetcode.java.easy._206;

import org.luvx.leetcode.ListNode;

/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 反转链表 迭代方式
     * <p>
     * 不依靠外部存储:迭代,递归
     * 使用外部存储:栈, list
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 直接移动
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * 迭代方式
     */
    public ListNode reverseList_1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head.next;
        head.next = null;
        while (head != null && current != null) {
            ListNode nextNext = current.next;
            current.next = head;
            head = current;
            current = nextNext;
        }
        return head;
    }

    /**
     * 递归方式1
     * 容易理解
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 递归方式2
     * 尾递归: java未对此做优化
     */
    public ListNode reverseList2_1(ListNode head) {
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}
// @lc code=end
