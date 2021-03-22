package org.luvx.leetcode.java.medium._725;

import org.junit.Test;
import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class SolutionTest {
    @Test
    public void splitListToParts() {
        Solution exec = new Solution();
        for (int i = 1; i < 15; i++) {
            ListNode h = Utils.initLinked(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
            ListNode[] listNodes = exec.splitListToParts(h, i);
            for (ListNode h1 : listNodes) {
                Utils.printLink(h1);
            }
        }
    }
}