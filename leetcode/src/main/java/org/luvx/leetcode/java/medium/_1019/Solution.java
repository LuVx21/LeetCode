package org.luvx.leetcode.java.medium._1019;

import org.luvx.leetcode.link.ListNode;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
 */

// @lc code=start
class Solution {
    /**
     * 2 -> 7 -> 4 -> 3 -> 5
     * 单调栈
     * 关联: No.496, No.503
     */
    public int[] nextLargerNodes(ListNode head) {
        int size = 0;
        for (var cur = head; cur != null; cur = cur.next) {
            size++;
        }
        int[] r = new int[size];

        var stack = new int[size][2];
        int si = -1;

        int index = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            while (si >= 0 && cur.val > stack[si][1]) {
                r[stack[si--][0]] = cur.val;
            }
            stack[++si] = new int[]{index, cur.val};
            index++;
        }

        return r;
    }
}
// @lc code=end
