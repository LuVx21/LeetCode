package org.luvx.leetcode.java.medium._1171;

import org.junit.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.Utils;

public class SolutionTest {
    @Test
    public void main() {
        ListNode head = Utils.initLinked(1, 2, -3, 3, 1);
        final Solution exec = new Solution();
        Utils.printLink(
                exec.removeZeroSumSublists(head)
        );
        head = Utils.initLinked(1, 2, 3, -3, 4);
        Utils.printLink(
                exec.removeZeroSumSublists(head)
        );
        head = Utils.initLinked(1, 2, 3, -3, -2);
        Utils.printLink(
                exec.removeZeroSumSublists(head)
        );
        head = Utils.initLinked(-1, -2, 2, -1, 0);
        Utils.printLink(
                exec.removeZeroSumSublists(head)
        );
    }
}