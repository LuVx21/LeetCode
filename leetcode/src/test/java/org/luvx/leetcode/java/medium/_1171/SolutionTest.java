package org.luvx.leetcode.java.medium._1171;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SolutionTest {
    @Test
    public void main() {
        ListNode head = LinkUtils.initLinked(1, 2, -3, 3, 1);
        final Solution exec = new Solution();
        LinkUtils.printLink(
                exec.removeZeroSumSublists(head)
        );
        head = LinkUtils.initLinked(1, 2, 3, -3, 4);
        LinkUtils.printLink(
                exec.removeZeroSumSublists(head)
        );
        head = LinkUtils.initLinked(1, 2, 3, -3, -2);
        LinkUtils.printLink(
                exec.removeZeroSumSublists(head)
        );
        head = LinkUtils.initLinked(-1, -2, 2, -1, 0);
        LinkUtils.printLink(
                exec.removeZeroSumSublists(head)
        );
    }
}