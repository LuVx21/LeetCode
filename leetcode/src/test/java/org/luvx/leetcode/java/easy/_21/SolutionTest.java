package org.luvx.leetcode.java.easy._21;

import junit.framework.TestCase;
import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class SolutionTest extends TestCase {

    public void testMergeTwoLists() {
        final Solution exec = new Solution();
        final ListNode h1 = Utils.initLinked(1, 2, 3);
        final ListNode h2 = Utils.initLinked(1, 3, 4);
        Utils.printLink(
                exec.mergeTwoLists(h1, h2)
        );
    }
}