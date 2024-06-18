package org.luvx.leetcode.link;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 链表节点
 *
 * @author Ren, Xie
 */
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    public ListNode pre;
    public int      val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(ListNode pre, int val) {
        this.pre = pre;
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            if (cur == this && cur.pre != null) {
                sb.append(cur.pre).append("<-");
            }
            sb.append(cur.val).append("->");
            cur = cur.next;
        }
        return sb.toString();
    }
}
