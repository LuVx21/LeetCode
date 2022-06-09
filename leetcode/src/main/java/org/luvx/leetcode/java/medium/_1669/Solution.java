package org.luvx.leetcode.java.medium._1669;

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;
/*
 * @lc app=leetcode.cn id=1669 lang=java
 *
 * [1669] 合并两个链表
 */

// @lc code=start

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
     * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将 list2 接在被删除节点的位置。
     * list1 = [0,1,2,3,4,5], a = 3, b = 4,
     * list2 = [1000000,1000001,1000002]
     * <p>
     * 0,1,2,1000000,1000001,1000002,5
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list1 == null) {
            return null;
        }
        ListNode pre = list1, next = list1;
        for (int i = 0; i <= b; i++) {
            if (i < a - 1) {
                pre = pre.next;
            }
            next = next.next;
        }
        pre.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = next;
        return list1;
    }

    public static void main(String[] args) {
        final Solution exec = new Solution();
        ListNode list1 = LinkUtils.initLinked(0, 1, 2, 3, 4, 5);
        ListNode list2 = LinkUtils.initLinked(1000000, 1000001, 1000002);
        LinkUtils.printLink(
                exec.mergeInBetween(list1, 3, 4, list2)
        );
        list1 = LinkUtils.initLinked(0, 1, 2, 3, 4, 5, 6);
        list2 = LinkUtils.initLinked(1000000, 1000001, 1000002, 1000003, 1000004);
        LinkUtils.printLink(
                exec.mergeInBetween(list1, 2, 5, list2)
        );
    }
}
// @lc code=end

