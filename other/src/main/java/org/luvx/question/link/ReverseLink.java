package org.luvx.question.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * * 1 -> 2 -> 3 -> 4 -> 5
 * 单链表反转
 */
public class ReverseLink {
    /**
     * 单链表反向
     * 1. 原头结点置空
     * 2. 循环结束条件
     *
     * @param head
     * @return
     */
    public static ListNode reverseLink(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode before = head;
        before.next = null;
        head = head.next;

        while (head != null) {
            ListNode temp = head.next;
            if (temp == null) {
                head.next = before;
                return head;
            }
            head.next = before;
            before = head;
            head = temp;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = LinkUtils.initLinked(1, 2, 3, 4, 5);

        LinkUtils.printLink(head);
        head = reverseLink(head);
        LinkUtils.printLink(head);
    }
}
