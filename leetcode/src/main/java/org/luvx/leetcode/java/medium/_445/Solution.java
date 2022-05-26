package org.luvx.leetcode.java.medium._445;

import org.luvx.leetcode.link.ListNode;

import java.util.Stack;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * </pre>
 */
class Solution {
    /**
     * 使用栈
     * <pre>
     * 7 -> 2 -> 4 -> 3
     *      5 -> 6 -> 4
     * =
     * 7 -> 8 -> 0 -> 7
     * </pre>
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return l2;
        }
        if (l2.val == 0) {
            return l1;
        }
        Stack<Integer> s1 = intoStack(l1), s2 = intoStack(l2);
        ListNode result = new ListNode(0);
        int nextValue = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                nextValue += s1.pop();
            }
            if (!s2.isEmpty()) {
                nextValue += s2.pop();
            }
            result.val = nextValue % 10;
            ListNode temp = new ListNode(nextValue / 10);
            temp.next = result;
            result = temp;
            nextValue /= 10;
        }
        return result.val == 0 ? result.next : result;
    }

    private Stack<Integer> intoStack(ListNode h) {
        Stack<Integer> stack = new Stack<>();
        while (h != null) {
            stack.push(h.val);
            h = h.next;
        }
        return stack;
    }

    public ListNode addTwoNumbers11(ListNode l1, ListNode l2) {
        int s1 = size(l1), s2 = size(l2);
        ListNode resHead = null;
        ListNode n = null;
        while (l1 != null || l2 != null) {
            int v1 = 0;
            int v2 = 0;
            if (s1 >= s2) {
                v1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                s1--;
            }
            if (s2 >= s1 + 1) {
                v2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2--;
            }
            n = new ListNode(v1 + v2);
            n.next = resHead;
            resHead = n;
        }
        int carry = 0;
        resHead = null;
        while (n != null) {
            n.val += carry;
            if (n.val >= 10) {
                n.val = n.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode buf = n.next;
            n.next = resHead;
            resHead = n;
            n = buf;
        }
        if (carry > 0) {
            n = new ListNode(1);
            n.next = resHead;
            resHead = n;
        }
        return resHead;
    }

    private int size(ListNode l) {
        int cnt = 0;
        while (l != null) {
            cnt++;
            l = l.next;
        }
        return cnt;
    }
}
// @lc code=end

