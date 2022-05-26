package org.luvx.leetcode.java.easy._141;

import org.luvx.leetcode.link.ListNode;

// @lc code=start
/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

/**
 * Definition for singly-linked list.
 * <pre>
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 */
import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * 递归方式
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle(nextNode);
    }

    public boolean hasCycle0(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * 迭代并检查是否出现过
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
// @lc code=end
