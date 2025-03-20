package easy

import (
	. "foobar/common/src/main/golang"
)

/*
 * @lc app=leetcode.cn id=222 lang=golang
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// 层数
func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	// 左右子树高度
	leftHeight, rightHeight := countLevel(root.Left), countLevel(root.Right)
	if leftHeight == rightHeight {
		return countNodes(root.Right) + (1 << leftHeight)
	} else {
		return countNodes(root.Left) + (1 << rightHeight)
	}
}
func countLevel(root *TreeNode) int {
	level := 0
	for root != nil {
		level++
		root = root.Left
	}
	return level
}

// 递归
func countNodes1(root *TreeNode) int {
	if root == nil {
		return 0
	}
	return 1 + countNodes(root.Left) + countNodes(root.Right)
}

// @lc code=end
