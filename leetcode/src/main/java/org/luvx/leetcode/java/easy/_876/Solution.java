package org.luvx.leetcode.java.easy._876;

import org.luvx.leetcode.ListNode;

// @lc code=start

/*
 * @lc app=leetcode.cn id=876 lang=java
 *
 * [876] 链表的中间结点
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
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * 如果有两个中间结点，则返回第二个中间结点。
     * 1,2,3,4,5 -> 3
     * 1,2,3,4,5,6 -> 4
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast.next == null) {
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
// @lc code=end

