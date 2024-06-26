package org.luvx.leetcode.java.easy._21;

import org.luvx.leetcode.link.ListNode;
/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
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
     * 将两个有序链表合并为一个新的有序链表并返回。
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(-1), pre = h;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return h.next;
    }

    /**
     * 递归
     */
    public ListNode mergeTwoLists0(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists0(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists0(l1, l2.next);
            return l2;
        }
    }
}
// @lc code=end

