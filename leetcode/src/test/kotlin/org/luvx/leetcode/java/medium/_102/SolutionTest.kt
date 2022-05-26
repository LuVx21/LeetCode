package org.luvx.leetcode.java.medium._102;

import org.luvx.leetcode.tree.TreeNode
import org.luvx.leetcode.out
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
    fun levelOrder() {
        val exec = Solution()
        val levelOrder = exec.levelOrder(root)
        levelOrder.out()
    }
}