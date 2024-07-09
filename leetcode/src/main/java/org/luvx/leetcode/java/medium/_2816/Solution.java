package org.luvx.leetcode.java.medium._2816;
/*
 * @lc app=leetcode.cn id=2816 lang=java
 *
 * [2816] 翻倍以链表形式表示的数字
 */

import org.luvx.leetcode.link.ListNode;

// @lc code=start
class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head.val > 4) {
            head = new ListNode(0, head);
        }
        for (ListNode cur = head; cur != null; cur = cur.next) {
            cur.val = (cur.val * 2) % 10 + (cur.next != null && cur.next.val > 4 ? 1 : 0);
        }
        return head;
    }

    public ListNode doubleIt0(ListNode head) {
        if (head.val == 0) {
            return head;
        }
        var cur = head;
        while (cur != null) {
            int v = cur.val * 2 + (cur.next != null && cur.next.val > 4 ? 1 : 0);
            if (v >= 10) {
                cur.val = v % 10;
                if (cur == head) {
                    head = new ListNode(v / 10, cur);
                }
            } else {
                cur.val = v;
            }
            cur = cur.next;
        }
        return head;
    }
}
// @lc code=end
