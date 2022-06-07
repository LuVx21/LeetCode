package org.luvx.offer.link;

import java.util.Stack;

import org.luvx.leetcode.link.ListNode;

class Offer05 {
    /**
     * 反向输出链表的结点值
     * 使用栈的方式进行
     *
     * @param head 链表头结点
     */
    public void printListInverselyUsingIteration(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            System.out.print(tmp.val + " ");
        }
    }

    /**
     * 反向输出链表的结点值
     * 使用递归的方式进行
     *
     * @param head 链表头结点
     */
    public void printListInverselyUsingRecursion(ListNode head) {
        if (head != null) {
            printListInverselyUsingRecursion(head.next);
            System.out.print(head.val + " ");
        }
    }
}
