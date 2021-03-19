package org.luvx.leetcode;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ren, Xie
 */
@Slf4j
@ToString
@AllArgsConstructor
public class ListNode {
    public int      val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
