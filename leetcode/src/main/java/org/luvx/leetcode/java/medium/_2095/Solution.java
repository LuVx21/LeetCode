package org.luvx.leetcode.java.medium._2095;
/*
 * @lc app=leetcode.cn id=2095 lang=java
 *
 * [2095] 删除链表的中间节点
 */

import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

// @lc code=start
class Solution {
    /**
     * 快慢指针, 快到走到最后, 慢的走到中间
     */
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        ListNode head = LinkUtils.initLinked(1, 3, 4, 7, 1, 2, 6);
        head = LinkUtils.initLinked(1, 2, 3, 4);
        head = LinkUtils.initLinked(2, 1);
        exec.deleteMiddle(head);
        LinkUtils.printLink(head);
    }
}
// @lc code=end

