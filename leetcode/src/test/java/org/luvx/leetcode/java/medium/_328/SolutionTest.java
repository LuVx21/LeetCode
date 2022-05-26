package org.luvx.leetcode.java.medium._328;

import org.junit.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.Utils;

public class SolutionTest {
    @Test
    public void main() {
        final Solution exec = new Solution();
        final ListNode h = Utils.initLinked(1, 2, 3, 4, 5);
        Utils.printLink(
                exec.oddEvenList(h)
        );
    }
}