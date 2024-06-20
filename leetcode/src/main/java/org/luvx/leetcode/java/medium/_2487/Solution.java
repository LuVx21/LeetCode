package org.luvx.leetcode.java.medium._2487;
/*
 * @lc app=leetcode.cn id=2487 lang=java
 *
 * [2487] 从链表中移除节点
 */

import org.luvx.leetcode.link.ListNode;

import java.util.Stack;

// @lc code=start
class Solution {

    /**
     * 递归
     */
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        var nextGreater = removeNodes(head.next);
        if (nextGreater == null || head.val >= nextGreater.val) {
            head.next = nextGreater;
            return head;
        }
        return nextGreater;
    }

    /**
     * 先反转
     * 5 <- 2 <- 13 <- 3 <- 8
     */
    public ListNode removeNodes_2(ListNode head) {
        head = reverse(head);

        ListNode dummy = new ListNode(-1);
        var cur = head;
        while (head != null) {
            if (cur.val > head.val) {
                head = head.next;
            } else {
                var next = head.next;
                head.next = dummy.next;
                dummy.next = head;
                cur = head;
                head = next;
            }
        }
        return dummy.next;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            var next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * dummy -> 5 -> 2 -> 13 -> 3 -> 8
     * 单调栈
     */
    public ListNode removeNodes_0(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE, head);
        var stack = new Stack<ListNode>();
        stack.push(dummy);

        for (var cur = head; cur != null; cur = cur.next) {
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            while (!stack.isEmpty() && stack.peek().val < cur.val) {
                stack.pop().next = null;
            }
            if (!stack.isEmpty() && stack.peek().val >= cur.val) {
                stack.peek().next = cur;
                stack.push(cur);
            }
        }
        return dummy.next;
    }

    /**
     * 超时,结果无法验证
     */
    public ListNode removeNodes_1(ListNode head) {
        ListNode dummy = new ListNode(0, head), pre = dummy, cur = head, fast = cur.next;
        while (fast != null) {
            while (fast != null && fast.val <= cur.val) {
                fast = fast.next;
            }
            if (fast == null) {
                pre = cur;
                cur = cur.next;
                if (cur != null) {
                    fast = cur.next;
                }
            } else {
                cur = cur.next;
                pre.next = cur;
            }
        }
        return dummy.next;
    }
}
// @lc code=end

