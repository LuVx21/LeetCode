package org.luvx.question;

import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class Q1669 {
    /**
     * leetcode-1669 扩展
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将 list2 接在被删除节点的位置。
     * <p>
     * a, b 其实是指下标,不是常规理解的第n个
     * 假设: ak可以为0, b可以为 list1.length - 1, 且有效
     * 0,1,2,3,4,5 [3, 4] 200,201,202
     * 0,1,2,200,201,202,5
     * <p>
     * [0,4] [2,5] [3,4]
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode pre = list1, next = list1;
        for (int i = 0; i <= b; i++) {
            if (i < a - 1) {
                pre = pre.next;
            }
            next = next.next;
        }
        if (pre == list1) {
            pre = list2;
        } else {
            pre.next = list2;
            pre = list1;
        }
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = next;
        return pre;
    }

    public static void main(String[] args) {
        final Q1669 exec = new Q1669();
        ListNode list1 = Utils.initLinked(0, 1, 2, 3, 4, 5);
        ListNode list2 = Utils.initLinked(200, 201, 202);
        Utils.printLink(
                // exec.mergeInBetween(list1, 3, 4, list2)
                // , exec.mergeInBetween(list1, 0, 4, list2)
                exec.mergeInBetween(list1, 0, 5, list2)
        );
    }
}
