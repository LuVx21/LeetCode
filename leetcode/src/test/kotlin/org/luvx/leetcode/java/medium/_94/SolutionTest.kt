package org.luvx.leetcode.java.medium._94;

import org.luvx.leetcode.tree.TreeNode
import org.luvx.coding.common.enhancer.out
import kotlin.test.BeforeTest
import kotlin.test.Test

class SolutionTest {
    private var root: TreeNode? = null

    @BeforeTest
    fun before() {
        root = TreeNode.of(
            5,
            TreeNode.of(
                4,
                TreeNode.of(
                    11,
                    TreeNode.of(7),
                    TreeNode.of(2)
                )
            ),
            TreeNode.of(
                8,
                TreeNode.of(13),
                TreeNode.of(
                    4, null,
                    TreeNode.of(1)
                )
            )
        )
    }

    /**
     * <pre>
     *          5
     *         / \
     *        4   8
     *       /   / \
     *      11  13  4
     *     /  \      \
     *    7    2      1
     * </pre>
     */
    @Test
    fun hasPathSumTest() {
        val exec = Solution()
        exec.inorderTraversal(root).out()
        exec.inorderTraversal1(root).out()
    }
}