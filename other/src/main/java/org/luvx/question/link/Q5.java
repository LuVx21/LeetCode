package org.luvx.question.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 给定一个单链表,使得奇数位置的元素位于偶数位置元素之前
 * 1->2->4->5->6
 * ↓
 * 1->4->6->2->5
 */
public class Q5 {
    public static ListNode modifiedLink01(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode oddNum = head;
        ListNode evenNum = head.next;
        ListNode evenHead = head.next;

        while (evenNum != null && evenNum.next != null) {
            oddNum.next = evenNum.next;
            oddNum = oddNum.next;
            evenNum.next = oddNum.next;
            evenNum = evenNum.next;
        }
        oddNum.next = evenHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkUtils.initLinked(2, 1, 2, 3, 4, 5);
        LinkUtils.printLink(head);
        head = modifiedLink01(head);
        LinkUtils.printLink(head);
    }
}
