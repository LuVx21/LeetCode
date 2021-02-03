package org.luvx.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ren, Xie
 */
@Slf4j
public class Utils {
    public static ListNode initLinked(int... array) {
        ListNode head = null, temp = null;
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                temp = new ListNode(array[i]);
                head = temp;
                continue;
            }
            temp.next = new ListNode(array[i]);
            temp = temp.next;
        }
        return head;
    }

    public static ListNode initLinked1(int... array) {
        ListNode[] ns = new ListNode[array.length];
        for (int i = 0; i < array.length; i++) {
            ListNode n = new ListNode(array[i]);
            ns[i] = n;
            if (i != 0) {
                ns[i - 1].next = n;
            }
        }
        ns[ns.length - 1].next = ns[1];
        return ns[0];
    }

    public static void printLink(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next == null ? "" : "->"));
            head = head.next;
        }
        System.out.println("\n--------------");
    }
}
