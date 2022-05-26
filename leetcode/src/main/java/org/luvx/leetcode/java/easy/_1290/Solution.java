package org.luvx.leetcode.java.easy._1290;

import org.luvx.leetcode.link.ListNode;

// @lc code=start
/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
 */

/**
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * </pre>
 */
class Solution {
    /**
     * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。
     * 已知此链表是一个整数数字的二进制表示形式。
     * <p>
     * 请你返回该链表所表示数字的 十进制值。
     * <p>
     * 1,0,1 -> 5
     * 1,0,0,1,0,0,1,1,1,0,0,0,0,0,0 -> 18880
     */
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int result = 0, len = linklistLen(head);
        while (len > 0) {
            result += head.val * Math.pow(2, --len);
            head = head.next;
        }
        return result;
    }

    private int linklistLen(ListNode head) {
        int cnt = 0;
        for (; head != null; head = head.next, cnt++) {
        }
        return cnt;
    }

    public int getDecimalValue1(ListNode head) {
        if (head.next != null) {
            head.next.val += (head.val << 1);
            return getDecimalValue1(head.next);
        }
        return head.val;
    }
}
// @lc code=end

