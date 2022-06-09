package org.luvx.question.link;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 链表去掉奇数位节点
 */
public class Q3 {
    /**
     * 移除奇数位节点:双向链表
     *
     * @return 头节点
     */
    public static ListNode removeSingleNode(ListNode head) {
        int index = 1;
        ListNode current = head;
        while (current != null) {
            if (index % 2 == 0) {
                current = current.next;
                index++;
                continue;
            }
            if (index == 1) {
                head = head.next;
                current = current.next;
                index++;
                continue;
            }
            current.pre.next = current.next;
            current = current.next;
        }
        return head;
    }

    /**
     * 移除奇数位节点:单向链表
     */
    public static ListNode removeSingleNode1(ListNode head) {
        int index = 1;
        ListNode current = head;
        while (current != null && current.next != null) {
            if (index % 2 == 0) {
                index++;
                continue;
            }
            if (index == 1) {
                head = head.next;
                current = head;
                index++;
                continue;
            }
            current.next = current.next.next;
            current = current.next != null ? current.next.next : null;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        ListNode head = LinkUtils.initLinked3(array);
        // Utils.printLink(head);
        // head = removeSingleNode(head);
        // Utils.printLink(head);


        head = LinkUtils.initLinked(array);
        LinkUtils.printLink(head);
        head = removeSingleNode1(head);
        LinkUtils.printLink(head);
    }
}
