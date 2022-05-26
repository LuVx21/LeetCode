package org.luvx.leetcode.java.medium._429;

import org.luvx.leetcode.tree.Node
import org.luvx.leetcode.out
import kotlin.test.BeforeTest
import kotlin.test.Test

class SolutionTest {
    private var root: Node? = null

    @BeforeTest
    fun before() {
        root = Node(
            5,
            listOf(
                Node(
                    4,
                    listOf(
                        Node(
                            11,
                            listOf(
                                Node(7),
                                Node(2),
                                Node(4)
                            )
                        )
                    )
                ),
                Node(
                    8,
                    listOf(
                        Node(13),
                        Node(
                            4,
                            listOf(
                                Node(1)
                            )
                        )
                    )
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
     *     /| \      \
     *    7 2  4      1
     * </pre>
     */
    @Test
    fun levelOrderTest() {
        val exec = Solution()
        exec.levelOrder(root).out()
    }
}