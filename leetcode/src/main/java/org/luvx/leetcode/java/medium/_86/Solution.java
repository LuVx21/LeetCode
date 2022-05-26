package org.luvx.leetcode.java.medium._86;

import org.luvx.leetcode.link.ListNode;

// @lc code=start
/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 */
class Solution {
    /**
     * 1,4,3,2,5,2
     * 3
     * ↓
     * 1,2,2,4,3,5
     * 小于和不小于的两个链表存储, 最后连接上
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0), smallHead = small;
        ListNode large = new ListNode(0), largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    /**
     * 定位到第一个大于等于 x 的节点, 然后在其前面插入后面遇到的小于 x 的节点
     */
    public ListNode partition0(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode newH = new ListNode(-1, head), cur = head, end = newH;
        while (cur != null && cur.val < x) {
            cur = cur.next;
            end = end.next;
        }
        ListNode pre = end;
        while (cur != null) {
            if (cur.val >= x) {
                cur = cur.next;
                pre = pre.next;
                continue;
            }
            pre.next = cur.next;
            cur.next = end.next;
            end = end.next = cur;
            cur = pre.next;
        }
        return newH.next;
    }
}
// @lc code=end

