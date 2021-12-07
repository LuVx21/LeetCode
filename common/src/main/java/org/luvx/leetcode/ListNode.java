package org.luvx.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Ren, Xie
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    public int      val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
