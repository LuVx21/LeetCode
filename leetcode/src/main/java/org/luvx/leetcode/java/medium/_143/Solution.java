package org.luvx.leetcode.java.medium._143;
/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

// @lc code=start
class Solution {
    /**
     * 1->2->3->4->5->6 -> 1->6->2->5->3->4
     * 1. 快慢指针找到3 和 5
     * 2. 后一半逆转
     * 3. 前一半和后一半相隔合并
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = slow, preCurrent = slow.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        slow = head;
        fast = preMiddle.next;
        while (slow != preMiddle) {
            preMiddle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = preMiddle.next;
        }
    }

    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            if (fast == null) {
                slow.next = null;
            }
            slow = next;
            if (fast != null && fast.next == null) {
                ListNode next1 = slow.next;
                slow.next = null;
                slow = next1;
            }
        }
        slow = reverse(slow);
        fast = head;
        ListNode temp = slow;
        while (temp != null) {
            ListNode fastNext = fast.next;
            ListNode slowNext = slow.next;
            head.next = temp;
            head = head.next;
            if (temp == fast) {
                slow = temp = slowNext;
            } else {
                fast = temp = fastNext;
            }
        }
    }

    // 反转链表:参见206题
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        ListNode head = Utils.initLinked(1, 2, 3, 4, 5, 6);
        exec.reorderList(head);
        Utils.printLink(head);
    }
}
// @lc code=end

