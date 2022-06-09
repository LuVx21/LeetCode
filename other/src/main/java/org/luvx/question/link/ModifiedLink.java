package org.luvx.question.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 链表:
 * 情形1:
 * 1->1->2->3->4->5
 * ↓
 * 1->1->3->5->2->4
 * 情形2:
 * 2->1->2->3->4->5
 * ↓
 * 1->3->5->2->2->4
 */
public class ModifiedLink {

    // public static Node modifiedLink0(Node head) {
    //     if (head == null || head.next == null)
    //         return head;
    //     boolean flag = false;
    //     Node current = head;
    //     while (current != null) {
    //         if (!flag && (current.data % 2 != 0)) {
    //             head = current;
    //             flag = true;
    //         }
    //
    //
    //         current = current.next;
    //     }
    //
    //
    //     if (head == null || head.next == null)
    //         return head;
    // }

    public static ListNode modifiedLink(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode _head = head;
        ListNode current = head;
        ListNode before = head;

        while (current != null) {
            if (current.val % 2 != 0) {
                head = current;
                break;
            }
            current = current.next;
        }

        current = _head;
        ListNode last = head;
        while (current != null) {
            if (current.val % 2 != 0 && current != head) {
                current.next = last.next;
                last.next = current;

            }
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode head = LinkUtils.initLinked(2, 1, 2, 3, 4, 5);
        LinkUtils.printLink(head);
        head = modifiedLink(head);
        LinkUtils.printLink(head);
    }
}
