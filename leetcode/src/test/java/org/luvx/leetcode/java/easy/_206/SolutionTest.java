package org.luvx.leetcode.java.easy._206;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SolutionTest {

    @Test
    public void testReverseList2_1() {
        final Solution exec = new Solution();
        ListNode h = LinkUtils.initLinked(1, 2, 3, 4, 5);
        LinkUtils.printLink(
                h = exec.reverseList2(h)
        );
        LinkUtils.printLink(
                exec.reverseList2_1(h)
        );
    }
}