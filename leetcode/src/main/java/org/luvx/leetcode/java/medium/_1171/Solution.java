package org.luvx.leetcode.java.medium._1171;

import org.luvx.leetcode.ListNode;

// @lc code=start
import java.util.HashMap;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 0  1,2,-3,3,1 -> 3,1
     */
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, pre);
        int sum = 0;
        for (ListNode current = head; current != null; current = current.next) {
            sum += current.val;
            if (!map.containsKey(sum)) {
                map.put(sum, current);
                continue;
            }
            ListNode start = map.get(sum), remove = start.next;
            int sum1 = sum;
            while (remove != current) {
                sum1 += remove.val;
                map.remove(sum1);
                remove = remove.next;
            }
            start.next = current.next;
        }
        return pre.next;
    }

    public ListNode removeZeroSumSublists0(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        int cnt = cnt(head), windowsSize = cnt;
        a:
        while (windowsSize > 0) {
            ListNode start = pre, end = pre;
            int sum = 0;
            for (int i = 0; i < windowsSize; i++) {
                end = end.next;
                sum += end.val;
            }
            while (end != null) {
                if (sum == 0) {
                    start.next = end.next;
                    end.next = null;
                    windowsSize = cnt -= windowsSize;
                    continue a;
                }
                start = start.next;
                end = end.next;
                sum -= start.val;
                if (end != null) {
                    sum += end.val;
                }
            }
            windowsSize--;
        }

        return pre.next;
    }

    private int cnt(ListNode head) {
        int cnt = 0;
        while (head != null) {
            cnt++;
            head = head.next;
        }
        return cnt;
    }
}
// @lc code=end
