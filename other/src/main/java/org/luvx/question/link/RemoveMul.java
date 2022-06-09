package org.luvx.question.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 链表去重复:
 * 0. 保留第一个重复的
 * 1. 不保留重复元素
 * 2. 保留最后一个重复元素
 */
public class RemoveMul {
    // 保留第一个元素
    public static ListNode removeMul0(ListNode head) {
        ListNode before = head;
        ListNode current = null;

        while (before != null) {
            current = before.next;
            if (current != null && current.val == before.val) {
                before.next = current.next;
            } else {
                before = current;
            }
        }

        return head;
    }

    // 不保留重复元素
    public static ListNode removeMul1(ListNode head) {
        while (head != null && head.val == head.next.val) {
            head = head.next.next;
        }

        ListNode before = head;
        ListNode current = before.next;
        ListNode next;
        boolean flag;

        while (current != null) {
            next = current.next;
            flag = false;
            while (next != null && current.val == next.val) {
                before.next = next;
                current = next;
                next = current.next;
                flag = true;
            }
            if (flag) {
                before.next = next;
            } else {
                before = current;
            }
            current = next;
        }
        return head;
    }

    public static ListNode removeMul2(ListNode head) {
        return head;
    }

    public static void main(String[] args) {
        // 1 -> 1 -> 1 -> 3 -> 4 -> 4 -> 5
        ListNode head = LinkUtils.initLinked(1, 1, 1, 3, 4, 4, 5);
        LinkUtils.printLink(head);
        head = removeMul1(head);
        // 3 5
        LinkUtils.printLink(head);
    }
}
