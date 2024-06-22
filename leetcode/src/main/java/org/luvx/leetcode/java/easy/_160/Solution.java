package org.luvx.leetcode.java.easy._160;

import org.luvx.leetcode.link.ListNode;
// @lc code=start
/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */
/**
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 */
import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * 逻辑上将两个链表合并, 会产生两个长度相同的链表
     * 重合的部分肯定位于这两个长链表的后面
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        List<ListNode> aa = new ArrayList<>();
        List<ListNode> bb = new ArrayList<>();
        while (a != null) {
            aa.add(a);
            a = a.next;
        }
        while (b != null) {
            bb.add(b);
            b = b.next;
        }

        int aaa = aa.size() - 1;
        int bbb = bb.size() - 1;

        while (true) {
            if (aa.get(aaa) != bb.get(bbb)) {
                return aa.get(aaa).next;
            }
            aaa--;
            bbb--;
        }
    }

    /**
     * 粗暴
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode temp = headB;
            while (temp != null) {
                if (headA == temp) {
                    return headA;
                }
                temp = temp.next;
            }
            headA = headA.next;
        }

        return null;
    }
}
// @lc code=end
