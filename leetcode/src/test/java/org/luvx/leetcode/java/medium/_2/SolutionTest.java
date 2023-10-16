package org.luvx.leetcode.java.medium._2;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {
        final Solution exec = new Solution();
        ListNode l1 = LinkUtils.initLinked(7), l2 = LinkUtils.initLinked(5, 6, 4, 9);
        LinkUtils.printLink(exec.addTwoNumbers(l1, l2));
    }
}