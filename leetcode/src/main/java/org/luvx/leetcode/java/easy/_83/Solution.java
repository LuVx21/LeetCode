package org.luvx.leetcode.java.easy._83;
/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */

import org.luvx.leetcode.link.ListNode;

// @lc code=start


/**
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            if (current.val == next.val) {
                current.next = next.next;
                next.next = null;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
// @lc code=end

