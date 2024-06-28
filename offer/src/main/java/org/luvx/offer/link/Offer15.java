package org.luvx.offer.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class Offer15 {
    /**
     * 输入一个键表，输出该链表中倒数第k 个结点．为了符合大多数人的习惯，
     * 本题从1开始计数，即链表的尾结点是倒数第1个结点．例如一个链表有6个结点，
     * 从头结点开始它们的值依次是1、2、3、4、5 6。这个链表的倒数第3个结点是值为4的结点．
     * 思路:
     * 快慢指针, 指针差距为k-1, 当快指针到尾, 慢指针正好到目标节点
     *
     * @param head 链表的头结点
     * @param k    倒数第k个结点
     * @return 倒数第k个结点
     */
    public static ListNode findKthToTail(ListNode head, int k) {
        // 输入的链表不能为空，并且k大于0
        if (k < 1 || head == null) {
            return null;
        }

        ListNode fast = head, slow = head;
        for (int i = 1; i < k; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    void main() {
        ListNode head = LinkUtils.initLinked(7, 15, 7, 4, 1, 1, 10, 17, 9, 3, 9, 14);
        ListNode k = findKthToTail(head, 5);
        System.out.println(k.val);
    }
}
