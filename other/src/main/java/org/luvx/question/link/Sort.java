package org.luvx.question.link;

import org.luvx.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class Sort {

    /**
     * https://leetcode-cn.com/circle/discuss/MT2uh9/
     * 给定一个链表，其中奇数位是升序的，偶数位是降序的，实现链表的排序
     * 奇数位个数 - 偶数位个数 = 1/0
     * <p>
     * 2,9,4,7,6,5,8,3,10,1
     * ↓
     * 2,1,4,3,6,5,8,7,10,9
     * ↓
     * 1,2,3,4,5,6,7,8,9,10
     */
    public ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next;
        ListNode oddHead = odd, evenHead = even;
        while (even != null && even.next != null) {
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }
        odd.next = null;

        final ListNode l = reverseList(evenHead);
        return mergeTwoLists(oddHead, l);
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public ListNode sort1(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        final LinkedList<ListNode> queue = new LinkedList<>();
        Stack<ListNode> stack = new Stack<>();
        boolean b = false;
        for (ListNode h = head; h != null; h = h.next, b = !b) {
            if (b) {
                stack.push(h);
            } else {
                queue.offer(h);
            }
        }
        head = queue.peek().val < stack.peek().val ? queue.poll() : stack.pop();
        ListNode current = head;
        while (!queue.isEmpty() && !stack.empty()) {
            current = current.next = (queue.peek().val < stack.peek().val) ? queue.poll() : stack.pop();
        }
        while (!queue.isEmpty()) {
            current = current.next = queue.poll();
        }
        while (!stack.empty()) {
            current = current.next = stack.pop();
        }
        current.next = null;
        return head;
    }
}
