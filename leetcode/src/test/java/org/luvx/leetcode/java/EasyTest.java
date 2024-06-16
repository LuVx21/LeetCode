package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.tree.Node;
import org.luvx.leetcode.tree.TreeNode;
import org.luvx.leetcode.util.TreeUtils;

class EasyTest extends BaseTest {
    @Test
    void m191() {
        exec(191, "hammingWeight", 11, 128, 2147483645);
    }

    @Test
    void m226() {
        int[] array = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root = TreeUtils.buildCBT(array);

        TreeNode root1 = TreeNode.of(2, TreeNode.of(1), TreeNode.of(3));
        exec(226, "invertTree", root, root1);
    }

    @Test
    void m344() {
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        char[] array1 = {'H', 'a', 'n', 'n', 'a', 'h'};
        exec(344, "reverseString", array, array1);
    }

    @Test
    void m389() {
        exec(389, "findTheDifference", "abcd", "abzcd");
    }

    @Test
    void m415() {
        exec(415, "addStrings1",
                "456", "902",
                "456", "9902"
        );
    }

    @Test
    void m559() {
        Node root = Node.of(1,
                Node.of(3, Node.of(5, Node.of(7)), Node.of(6)),
                Node.of(2),
                Node.of(4)
        );
        exec(559, "maxDepth", root);
    }

    @Test
    void m697() {
        int[] array = {1, 2, 2, 3, 1, 4, 2};
        int[] array1 = {1, 2, 2, 3, 1};
        exec(697, "findShortestSubArray", array, array1);
    }

    @Test
    void m1154() {
        exec(1154, "dayOfYear",
                "2019-01-09", "2019-02-10"
        );
    }

    @Test
    void m2129() {
        exec(2129, "capitalizeTitle",
                "capiTalIze tHe titLe",
                "First leTTeR of EACH Word",
                "i lOve leetcode"
        );
    }

    @Test
    void m2574() {
        exec(2574, "leftRigthDifference", (Object) new int[]{10, 4, 8, 3});
    }
}
