package org.luvx.leetcode.java.medium._107;

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
                TreeNode.of(
                    13
                ),
                TreeNode.of(
                    4,
                    null,
                    TreeNode.of(1)
                )
            )
        )
    }

    @Test
    fun levelOrderBottom() {
        val exec = Solution()
        exec.levelOrderBottom(root).out()
        exec.levelOrderBottom1(root).out()
    }
}