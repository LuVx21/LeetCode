package org.luvx.leetcode.java.medium._19;

import org.junit.Test;
import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class SolutionTest {
    @Test
    public void removeNthFromEndTest() {
        Solution exec = new Solution();
        for (int i = 1; i <= 5; i++) {
            ListNode h = Utils.initLinked(1, 2, 3, 4, 5);
            Utils.printLink(
                    exec.removeNthFromEnd(h, i)
            );
        }
    }
}