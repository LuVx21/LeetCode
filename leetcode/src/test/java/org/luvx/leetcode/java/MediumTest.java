package org.luvx.leetcode.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.luvx.leetcode.link.ListNode;
import org.luvx.leetcode.tree.TreeNode;
import org.luvx.leetcode.util.TreeUtils;

import static org.luvx.leetcode.util.LinkUtils.initLinked;

@Slf4j
class MediumTest extends BaseTest {
    @Test
    void m3() {
        exec(3, "lengthOfLongestSubstring", "abcabcbb", "pwwkew", "dvdf");
    }

    @Test
    void m6() {
        exec(6, "convert"
                , "PAYPALISHIRING", 3
                , "PAYPALISHIRING", 4
                , "PAYPALISHIRING", 5
                , "A", 1
        );
    }

    @Test
    void m17() {
        exec(17, "letterCombinations", "23", "", "2");
    }

    @Test
    void m34() {
        int[] array = {5, 7, 7, 8, 8, 9, 10};
        exec(34, "searchRange", array, 8, array, 9, array, 11);
    }

    @Test
    void m36() {
        char[][] array = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        exec(36, "isValidSudoku", (Object) array);
    }

    @Test
    void m39() {
        exec(39, "combinationSum", array(2, 3, 6, 7), 7, array(2, 3, 5), 8);
    }

    @Test
    void m40() {
        exec(40, "combinationSum2", array(10, 1, 2, 7, 6, 1, 5), 8);
    }

    @Test
    void m47() {
        exec(47, "permuteUnique", array(1, 1, 2), array(1, 2, 3));
    }

    @Test
    void m55() {
        exec(55, "canJump3", array(2, 3, 1, 1, 4), array(3, 2, 1, 0, 4), array(3, 2, 2, 0, 4));
    }

    @Test
    void m71() {
        exec(71, "simplifyPath", "/home/", "/../", "/home//foo/",
                "/a/./b/../../c/", "/a/./b//../../c/");
    }

    @Test
    void m74() {
        int[][] array1 = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        exec(74, "searchMatrix", array1, 3, array1, 13);
    }

    @Test
    void m98() {
        TreeNode root = TreeUtils.buildCBT(5, 4, 6, null, null, 3, 7);
        // TreeNode root = TreeUtils.buildCBT(2, 1, 3);
        TreeNode root1 = TreeUtils.buildCBT(5, 1, 4, null, null, 3, 6);
        exec(98, "isValidBST", root, root1);
    }

    @Test
    void m102() {
        TreeNode root = TreeUtils.buildCBT(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1);
        TreeNode root1 = TreeUtils.buildCBT(3, 9, 20, null, null, 15, 7);
        exec(102, "levelOrder", root, root1);
    }

    @Test
    void m114() {
        TreeNode root = TreeUtils.buildCBT(1, 2, 5, 3, 4, null, 6);
        TreeNode root2 = TreeUtils.buildCBT(0);
        exec(114, "flatten"
                , root
                , root2
        );
    }

    @Test
    void m137() {
        int[] i1 = {2, 2, 3, 2};
        int[] i2 = {0, 1, 0, 1, 0, 1, 99};
        exec(137, "singleNumber", i1, i2);
    }

    @Test
    void m150() {
        String[][] i1 = {
                {"18"},
                {"2", "1", "+", "3", "*"},
                {"4", "13", "5", "/", "+"},
                {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}
        };
        exec(150, "evalRPN", i1);
    }

    @Test
    void m162() {
        int[][] arg = {
                {1, 2, 3, 1},
                {1, 2, 1, 3, 5, 6, 4}
        };
        exec(162, "findPeakElement", arg);
    }

    @Test
    void m198() {
        int[][] arg = {
                {1, 2, 3, 1},
                {1, 3, 1},
                {2, 7, 9, 3, 1},
                {2, 1, 1, 2},
        };
        exec(198, "rob", arg);
    }

    @Test
    void m201() {
        exec(201, "rangeBitwiseAnd", 5, 7, 0, 0, 1, 2147483646);
    }

    @Test
    void m221() {
        char[][][] array = {
                {{'0'}},
                {{'1'}},
                {{'0', '1'}, {'1', '0'}},
                {{'1', '1'}, {'1', '1'}},
                {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}},
        };
        exec(221, "maximalSquare", array);
    }

    @Test
    void m209() {
        exec(209, "minSubArrayLen", 7, new int[]{2, 3, 1, 2, 4, 3},
                4, new int[]{1, 4, 4},
                11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}
        );
    }

    @Test
    void m236() {
        TreeNode root = TreeUtils.buildCBT(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
        TreeNode root1 = TreeUtils.buildCBT(1, 2);
        exec(236, "lowestCommonAncestor",
                root, root.left, root.right
                , root, root.left, root.left.right.right
                , root1, root1, root1.left
        );
    }

    @Test
    void m260() {
        exec(260, "singleNumber",
                array(1, 2, 1, 3, 2, 5),
                array(-1, 0),
                array(0, 1)
        );
    }

    @Test
    void m300() {
        int[][] arg = {
                {7, 7, 7, 7, 7, 7, 7},
                {0, 1, 0, 3, 2, 3},
                {10, 9, 2, 5, 3, 7, 101, 18},
                {4, 10, 4, 3, 8, 9}
        };
        exec(300, "lengthOfLIS", arg);
    }

    @Test
    void m371() {
        exec(371, "getSum", 1, 2, 2, 3);
    }

    @Test
    void m421() {
        int[] array = {3, 10, 5, 25, 2, 8};
        // int[] array = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        exec(421, "findMaximumXOR", array);
    }

    @Test
    void m477() {
        int[] array1 = {4, 14, 2};
        int[] array2 = {4, 14, 4};
        exec(477, "totalHammingDistance", array1, array2);
    }

    @Test
    void m503() {
        int[] a1 = {1, 2, 1}, a2 = {1, 2, 3, 4, 3}, a3 = {1, 2, 3, 4, 3, 2};
        int[] a4 = {1, 1, 1, 1, 1};
        exec(503, "nextGreaterElements", a1, a2, a3, a4);
    }

    @Test
    void m560() {
        int[] array = {1, 2, 3, 0, 3};
        exec(560, "subarraySum",
                array, 3, array, 5
        );
    }

    @Test
    void m739() {
        int[][] array = {
                {73, 74, 75, 71, 69, 72, 76, 73}, {30, 40, 50, 60}, {30, 60, 90},
                {89, 62, 70, 58, 47, 47, 46, 76, 100, 70},
                {34, 80, 80, 34, 34, 80, 80, 80, 80, 34}
        };
        exec(739, "dailyTemperatures", array);
    }

    @Test
    void m1019() {
        ListNode h1 = initLinked(2, 1, 5), h2 = initLinked(2, 7, 4, 3, 5);
        exec(1019, "nextLargerNodes", h1, h2);
    }

    @Test
    void m1049() {
        exec(1049, "lastStoneWeightII", array(2, 7, 4, 1, 8, 1), array(31, 26, 33, 21, 40));
    }

    @Test
    void m1143() {
        String[] array = {
                "abcde", "ace",
                "abcfbc", "abfcab",
                "programming", "contest",
                "abcd", "mnp"
        };
        exec(1143, "longestCommonSubsequence", array);
    }

    @Test
    void m1262() {
        int[][] array = {
                {3, 6, 5, 1, 8},
                {4},
                {1, 2, 3, 4, 4}
        };
        exec(1262, "maxSumDivThree", array);
    }

    @Test
    void m1669() {
        ListNode list1 = initLinked(0, 1, 2, 3, 4, 5), list2 = initLinked(1000000, 1000001, 1000002);
        exec(1669, "mergeInBetween", list1, 3, 4, list2,
                initLinked(0, 1, 2, 3, 4, 5, 6),
                2, 5,
                initLinked(1000000, 1000001, 1000002, 1000003, 1000004)
        );
    }

    @Test
    void m2487() {
        ListNode h1 = initLinked(5, 2, 13, 3, 8);
        ListNode h2 = initLinked(1, 1, 1, 1);
        exec(2487, "removeNodes", h1
                , h2
        );
    }

    @Test
    void m2807() {
        ListNode h1 = initLinked(18, 6, 10, 3);
        ListNode h2 = initLinked(7);
        exec(2807, "insertGreatestCommonDivisors", h1, h2);
    }

    @Test
    void m2816() {
        ListNode h1 = initLinked(1, 8, 9);
        ListNode h2 = initLinked(9, 9, 9);
        exec(2816, "doubleIt", h1, h2);
    }

    @Test
    void m3101() {
        exec(3101, "countAlternatingSubarrays", array(0, 1, 1, 1), array(1, 0, 1, 0));
    }
}
