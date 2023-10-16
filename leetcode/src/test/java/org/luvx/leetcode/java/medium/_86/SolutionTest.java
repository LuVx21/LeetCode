package org.luvx.leetcode.java.medium._86;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SolutionTest {
    @Test
    public void partition() {
        Solution exec = new Solution();
        ListNode h = LinkUtils.initLinked(1, 4, 3, 2, 5, 2);
        LinkUtils.printLink(exec.partition(h, 3));
        h = LinkUtils.initLinked(1);
        LinkUtils.printLink(exec.partition(h, 1));
    }
}