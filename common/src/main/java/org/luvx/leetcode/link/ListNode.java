package org.luvx.leetcode.link;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 链表节点
 *
 * @author Ren, Xie
 */
@ToString
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
}
