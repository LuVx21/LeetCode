package org.luvx.leetcode.java.easy._141;

import org.luvx.leetcode.ListNode;

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

    /**
     * 迭代并检查是否出现过
     */
    public boolean hasCycle0(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
// @lc code=end
