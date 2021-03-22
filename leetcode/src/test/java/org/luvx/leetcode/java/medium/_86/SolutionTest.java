package org.luvx.leetcode.java.medium._86;

import org.junit.Test;
import org.luvx.leetcode.ListNode;
import org.luvx.leetcode.Utils;

public class SolutionTest {
    @Test
    public void partition() {
        Solution exec = new Solution();
        ListNode h = Utils.initLinked(1, 4, 3, 2, 5, 2);
        Utils.printLink(exec.partition(h, 3));
        h = Utils.initLinked(1);
        Utils.printLink(exec.partition(h, 1));
    }
}