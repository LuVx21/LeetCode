package org.luvx.offer.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 关联: No.237
 */
public class Offer13 {

    /**
     * 删除链表中指定值的节点
     *
     * @param head 头节点
     * @param val  待删除的值
     * @return 删除后的头节点
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(-1, head), cur = head, pre = dummy;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }
        return dummy.next;
    }

    void main() {
        ListNode head = LinkUtils.initLinked(7, 15, 7, 4, 1, 1, 10, 17, 9, 3, 9, 14);

        head = deleteNode(head, 7);
        // head = deleteNode(head, 4);
        // head = deleteNode(head, 1);
        // head = deleteNode(head, 9);

        System.out.println(head);
    }
}
