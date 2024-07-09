package org.luvx.leetcode.java.medium._2807;
/*
 * @lc app=leetcode.cn id=2807 lang=java
 *
 * [2807] 在链表中插入最大公约数
 */

import org.luvx.leetcode.link.ListNode;

// @lc code=start
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode gcd = gcd(cur.val, next.val);
            cur.next = gcd;
            gcd.next = next;
            cur = next;
        }
        return head;
    }

    public ListNode gcd(int a, int b) {
        if (b > a) {
            var t = b;
            b = a;
            a = t;
        }
        while (b != 0) {
            var t = b;
            b = a % b;
            a = t;
        }
        return new ListNode(a);
    }
}
// @lc code=end
