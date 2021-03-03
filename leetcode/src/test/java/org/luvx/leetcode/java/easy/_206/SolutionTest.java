package org.luvx.leetcode.java.easy._206;

import org.junit.Test;
import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class SolutionTest {

    @Test
    public void testReverseList2_1() {
        final Solution exec = new Solution();
        ListNode h = Utils.initLinked(1, 2, 3, 4, 5);
        Utils.printLink(
                h = exec.reverseList2(h)
        );
        Utils.printLink(
                exec.reverseList2_1(h)
        );
    }
}