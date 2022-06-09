package org.luvx.leetcode.java.easy._21;

import junit.framework.TestCase;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.LinkUtils;

public class SolutionTest extends TestCase {

    public void testMergeTwoLists() {
        final Solution exec = new Solution();
        final ListNode h1 = LinkUtils.initLinked(1, 2, 3);
        final ListNode h2 = LinkUtils.initLinked(1, 3, 4);
        LinkUtils.printLink(
                exec.mergeTwoLists(h1, h2)
        );
    }
}