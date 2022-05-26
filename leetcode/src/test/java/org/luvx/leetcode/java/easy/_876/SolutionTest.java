package org.luvx.leetcode.java.easy._876;

import org.junit.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.util.Utils;

public class SolutionTest {
    @Test
    public void middleNodeTest() {
        Solution exec = new Solution();
        ListNode h = Utils.initLinked(1, 2, 3, 4, 5, 6);
        System.out.println(exec.middleNode(h));
    }
}