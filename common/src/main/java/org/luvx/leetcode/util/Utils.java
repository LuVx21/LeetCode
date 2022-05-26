package org.luvx.leetcode.util;

import org.luvx.leetcode.link.ListNode;

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

    public static ListNode initLinked3(int... array) {
        if (array.length == 0) {
            throw new RuntimeException();
        }
        ListNode head = new ListNode(null, array[0], null), cur = head;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(cur, array[i], null);
            cur = cur.next;
        }
        return head;
    }

    public static void printLink(ListNode... heads) {
        for (ListNode head : heads) {
            while (head != null) {
                System.out.print(head.val + (head.next == null ? "" : "->"));
                head = head.next;
            }
            System.out.println("\n--------------");
        }
    }

    public static void printLink1(ListNode head) {
        while (head != null) {
            String s = "%s->%s->%s";
            s = String.format(s,
                    head.pre == null ? "null" : head.pre.val,
                    head.val,
                    head.next == null ? "null" : head.next.val
            );
            System.out.println(s);
            head = head.next;
        }
    }
}
