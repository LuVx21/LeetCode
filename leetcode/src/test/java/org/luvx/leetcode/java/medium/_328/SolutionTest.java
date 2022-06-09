package org.luvx.leetcode.java.medium._328;

import org.junit.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SolutionTest {
    @Test
    public void main() {
        final Solution exec = new Solution();
        final ListNode h = LinkUtils.initLinked(1, 2, 3, 4, 5);
        LinkUtils.printLink(
                exec.oddEvenList(h)
        );
    }
}