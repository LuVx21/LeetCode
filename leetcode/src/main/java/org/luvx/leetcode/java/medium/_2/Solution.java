package org.luvx.leetcode.java.medium._2;

import org.luvx.leetcode.ListNode;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

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
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
     * <p>
     * 2-4-3 5-6-4 -> 708
     * 342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), current = result;
        int nextValue = 0;
        while (l1 != null || l2 != null || nextValue != 0) {
            if (l1 != null) {
                nextValue += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                nextValue += l2.val;
                l2 = l2.next;
            }
            current = current.next = new ListNode(nextValue % 10);
            nextValue /= 10;
        }
        return result.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0), current = result;
        int plus = 0;
        while (l1 != null && l2 != null) {
            final int i = l1.val + l2.val + plus;
            plus = i / 10;
            current = current.next = new ListNode(i % 10);
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            final int i = l1.val + plus;
            plus = i / 10;
            current = current.next = new ListNode(i % 10);
            l1 = l1.next;
        }
        while (l2 != null) {
            final int i = l2.val + plus;
            plus = i / 10;
            current = current.next = new ListNode(i % 10);
            l2 = l2.next;
        }
        if (plus != 0) {
            current.next = new ListNode(plus);
        }
        return result.next;
    }

    // 如果存储是顺序存储呢, 如:
    // 342: 3 -> 4 -> 2
    // 465: 4 -> 6 -> 5
    // 807: 8 -> 0 -> 7
    //
    // 先逆序在计算
    // 栈直接计算或转为逆序再计算
}
// @lc code=end
