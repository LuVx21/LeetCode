package org.luvx.question.link;

import static org.luvx.leetcode.util.LinkUtils.initLinked;

import java.util.stream.Stream;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

/**
 * 链表去重复:
 * 0. 保留第一个重复的
 * 1. 不保留重复元素
 * 2. 保留最后一个重复元素
 */
public class RemoveMul {
    // 保留第一个元素
    public static ListNode removeMul0(ListNode head) {
        ListNode before = head;
        ListNode current = null;

        while (before != null) {
            current = before.next;
            if (current != null && current.val == before.val) {
                before.next = current.next;
            } else {
                before = current;
            }
        }

        return head;
    }

    // 不保留重复元素
    public static ListNode removeMul1(ListNode head) {
        while (head != null) {
            ListNode cur = head.next;
            if (cur == null || head.val != cur.val) {
                break;
            }
            for (; cur != null && cur.val == head.val; cur = cur.next) {
                head = cur;
            }
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        ListNode pre = head, cur = head.next;
        while (cur != null) {
            ListNode next = cur.next;
            boolean flag = false;
            while (next != null && cur.val == next.val) {
                pre.next = cur = next;
                next = cur.next;
                flag = true;
            }
            if (flag) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return head;
    }

    public static ListNode removeMul2(ListNode head) {
        return head;
    }

    public static void main(String[] args) {
        Stream.of(
                        initLinked(1, 1, 1, 3, 4, 4, 5),
                        initLinked(1, 1, 1, 3, 3, 4, 4, 5),
                        initLinked(1, 1, 1, 1, 3, 3, 4, 4, 5)
                )
                .peek(LinkUtils::printLink)
                .map(RemoveMul::removeMul1)
                .forEachOrdered(LinkUtils::printLink);
    }
}
