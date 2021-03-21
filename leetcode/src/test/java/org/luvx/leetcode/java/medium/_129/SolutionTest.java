package org.luvx.leetcode.java.medium._129;

import org.junit.Test;
import org.luvx.leetcode.TreeNode;

public class SolutionTest {
    /**
     * <pre>
     *      1
     *     2  3
     *    4 5 6 7
     * </pre>
     * 124 + 125 + 136 + 137
     */
    @Test
    public void sumNumbersTest() {
        Solution exec = new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        int i = exec.sumNumbers0(root);
        System.out.println(i);
    }
}