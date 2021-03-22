package org.luvx.leetcode.java.medium._2;

import org.junit.Test;
import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {
        final Solution exec = new Solution();
        ListNode l1 = Utils.initLinked(7), l2 = Utils.initLinked(5, 6, 4, 9);
        Utils.printLink(exec.addTwoNumbers(l1, l2));
    }
}