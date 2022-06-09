package org.luvx.question.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 反转链表的前 K 个节点
 */
public class ReverseKLink {
    /**
     * 1->2->3->4->5->6 3
     * ↓
     * 3->2->1->4->5->6
     * 假设入参合法
     */
    private ListNode reverseK(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode p = head.next, newHead = head;
        for (int i = 1; i < k; i++) {
            head.next = p.next;
            p.next = newHead;
            newHead = p;
            p = head.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseKLink exec = new ReverseKLink();
        ListNode head = LinkUtils.initLinked(1, 2, 3, 4, 5, 6);
        head = exec.reverseK(head, 3);
        LinkUtils.printLink(head);
    }
}
