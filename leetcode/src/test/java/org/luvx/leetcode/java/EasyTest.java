package org.luvx.leetcode.java;

import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.tree.Node;
import org.luvx.leetcode.tree.TreeNode;
import org.luvx.leetcode.util.LinkUtils;
import org.luvx.leetcode.util.TreeUtils;

class EasyTest extends BaseTest {
    @Test
    void m21() {
        final ListNode h1 = LinkUtils.initLinked(1, 2, 3);
        final ListNode h2 = LinkUtils.initLinked(1, 3, 4);
        exec(21, "mergeTwoLists", h1, h2);
    }

    @Test
    void m104() {
        TreeNode root = TreeUtils.buildCBT(3, 9, 20, null, null, 15, 7);
        TreeNode root1 = TreeUtils.buildCBT(1, null, 2);
        exec(104, "maxDepth", root, root1);
    }

    @Test
    void m108() {
        exec(108, "sortedArrayToBST", array(-10, -3, 0, 5, 9), array(1, 3),
                array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17)
        );
    }

    @Test
    void _110() {
        TreeNode root = TreeUtils.buildCBT(3, 9, 20, null, null, 15, 7);
        TreeNode root1 = TreeUtils.buildCBT(1, 2, 2, 3, 3, null, null, 4, 4);
        exec(110, "isBalanced", root, root1);
    }

    @Test
    void _111() {
        TreeNode root = TreeUtils.buildCBT(3, 9, 20, null, null, 15, 7);
        TreeNode root1 = TreeUtils.buildCBT(2, null, 3, null, 4, null, 5, null, 6);
        exec(111, "minDepth", root, root1);
    }

    @Test
    void m191() {
        exec(191, "hammingWeight", 11, 128, 2147483645);
    }

    @Test
    void m206() {
        ListNode h = LinkUtils.initLinked(1, 2, 3, 4, 5);
        exec(206, "reverseList", h);
    }

    @Test
    void m226() {
        TreeNode root = TreeUtils.buildCBT(4, 2, 7, 1, 3, 6, 9);

        TreeNode root1 = TreeNode.of(2, TreeNode.of(1), TreeNode.of(3));
        exec(226, "invertTree", root, root1);
    }

    @Test
    void m228() {
        int[][] array = {
                {0, 1, 2, 4, 5, 7},
                {0, 2, 3, 4, 6, 8, 9}
        };
        exec(228, "summaryRanges", array);
    }

    @Test
    void _257() {
        TreeNode root = TreeUtils.buildCBT(1, 2, 3, null, 5);
        TreeNode root1 = TreeUtils.buildCBT(1);
        exec(257, "binaryTreePaths1", root, root1);
    }

    @Test
    void m283() {
        int[][] array = {
                {0, 1, 0, 3, 12},
                {0}
        };
        exec(283, "moveZeroes", array);
    }

    @Test
    void m326() {
        exec(326, "isPowerOfThree", 27, 0, 9, 45, 18);
    }

    @Test
    void m338() {
        exec(338, "countBits", 2, 5);
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
    void m392() {
        exec(392, "isSubsequence", "abc", "ahbgdc", "acb", "ahbgdc", "axc", "ahbgdc");
    }

    @Test
    void m405() {
        exec(405, "toHex", 26, -1, -26);
    }

    @Test
    void m414() {
        exec(414, "thirdMax", array(3, 2, 1), array(1, 2), array(2, 2, 3, 1), array(3, 3, 3, 1, 2));
    }

    @Test
    void m415() {
        exec(415, "addStrings1",
                "456", "902",
                "456", "9902"
        );
    }

    @Test
    void m434() {
        exec(434, "countSegments", "Hello, my name is John", " a b c  d ", "", " ", "                ");
    }

    @Test
    void m461() {
        exec(461, "hammingDistance", 1, 4, 3, 1);
    }

    @Test
    void m496() {
        int[][] arg = {
                {4, 1, 2}, {1, 3, 4, 2},
                {2, 4}, {1, 2, 3, 4},
                {3, 1, 5, 7, 9, 2, 6}, {1, 2, 3, 5, 6, 7, 9, 11}
        };
        exec(496, "nextGreaterElement", arg);
    }

    @Test
    void m501() {
        TreeNode root = TreeUtils.buildCBT(1, 0, 1, 0, 0, 1, 1, 0);
        exec(501, "findMode", root);
    }

    @Test
    void m504() {
        exec(504, "convertToBase7", 101, -7, 7, 3, -3, 0, 1, -1);
    }

    @Test
    void m506() {
        int[] array1 = {5, 4, 3, 2, 1};
        int[] array2 = {10, 3, 8, 9, 4};
        int[] array3 = {13, 6, 15, 38, 23};
        exec(506, "findRelativeRanks", array1, array2, array3);
    }

    @Test
    void m530() {
        TreeNode root1 = TreeUtils.buildCBT(236, 104, 701, null, 227, null, 911);
        // TreeNode root1 = TreeUtils.buildCBT(4, 2, 6, 1, 3);
        TreeNode root2 = TreeUtils.buildCBT(1, 0, 48, null, null, 12, 49);
        exec(530, "getMinimumDifference", root1, root2);
    }

    @Test
    void m557() {
        exec(557, "reverseWords", "Let's take LeetCode contest", "Mr Ding", "void swap(char[] array, int i, int j) {", "I love u");
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
    void _617() {
        TreeNode root0 = TreeUtils.buildCBT(1, 3, 2, 5), root1 = TreeUtils.buildCBT(2, 1, 3, null, 4, null, 7);
        TreeNode root2 = TreeUtils.buildCBT(1), root3 = TreeUtils.buildCBT(1, 2);
        exec(617, "mergeTrees", root0, root1,
                root2, root3);
    }

    @Test
    void m653() {
        TreeNode root = TreeUtils.buildCBT(5, 3, 6, 2, 4, null, 7);
        exec(653, "findTarget", root, 9, root, 28);
    }

    @Test
    void m697() {
        int[] array = {1, 2, 2, 3, 1, 4, 2};
        int[] array1 = {1, 2, 2, 3, 1};
        exec(697, "findShortestSubArray", array, array1);
    }

    @Test
    void m724() {
        int[] array1 = {1, 7, 3, 6, 5, 6};
        int[] array2 = {1, 2, 3};
        int[] array3 = {2, 1, -1};
        int[] array4 = {2, 3, -1, 8, 4};
        int[] array5 = {1, -1, 4};
        int[] array6 = {2, 5};
        int[] array7 = {1};
        exec(724, "pivotIndex", array1, array2, array3, array4, array5, array6, array7);
    }

    @Test
    void m762() {
        exec(762, "countPrimeSetBits", 6, 10, 10, 15);
    }

    @Test
    void m766() {
        int[][] array1 = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] array2 = {{1, 2}, {2, 2}};
        exec(766, "isToeplitzMatrix", array1, array2);
    }

    @Test
    void m876() {
        ListNode h = LinkUtils.initLinked(1, 2, 3, 4, 5, 6);
        exec(876, "middleNode", h);
    }

    @Test
    void m896() {
        int[][] array = {{1, 2, 3, 4, 5}, {6, 5, 4, 4}, {1, 3, 2}, {1, 1, 1, 1, 1}};
        exec(896, "isMonotonic", array);
    }

    @Test
    void m938() {
        TreeNode root = TreeUtils.buildCBT(10, 5, 15, 3, 7, null, 18);
        TreeNode root1 = TreeUtils.buildCBT(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
        exec(938, "rangeSumBST"
                , root, 7, 15
                , root1, 6, 10
        );
    }

    @Test
    void m977() {
        int[][] h = {{-4, -1, 0, 3, 10}, {-7, -3, 2, 3, 11}, {-3}};
        exec(977, "sortedSquares", h);
    }

    @Test
    void m1154() {
        exec(1154, "dayOfYear",
                "2019-01-09", "2019-02-10"
        );
    }

    @Test
    void m1122() {
        exec(1122, "relativeSortArray",
                array(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19), array(2, 1, 4, 3, 9, 6),
                array(28, 6, 22, 8, 44, 17), array(22, 28, 8, 6)
        );
    }

    @Test
    void m1317() {
        exec(1317, "getNoZeroIntegers", 2, 11, 10000, 69, 1010);
    }

    @Test
    void m1342() {
        exec(1342, "numberOfSteps", 14, 8, 123);
    }

    @Test
    void m1475() {
        int[][] arg = {{8, 4, 6, 2, 3}, {1, 2, 3, 4, 5}, {10, 1, 1, 6}};
        exec(1475, "finalPrices", arg);
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
    void m2220() {
        exec(2220, "minBitFlips", 10, 7, 3, 4);
    }

    @Test
    void m2574() {
        int[] array1 = {10, 4, 8, 3}, array2 = {1};
        exec(2574, "leftRigthDifference", array1, array2);
    }

    @Test
    void m3174() {
        exec(3174, "clearDigits", "abc", "cb34", "");
    }
}
