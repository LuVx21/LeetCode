package org.luvx.leetcode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Ren, Xie
 */
@Slf4j
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
