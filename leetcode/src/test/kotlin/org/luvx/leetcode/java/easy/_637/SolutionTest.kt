package org.luvx.leetcode.java.easy._637;

import org.luvx.leetcode.TreeNode
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
                TreeNode.of(13),
                TreeNode.of(
                    4, null,
                    TreeNode.of(1)
                )
            )
        )
    }

    @Test
    fun averageOfLevels() {
        val exec = Solution()
        exec.averageOfLevels(root).out()
    }
}