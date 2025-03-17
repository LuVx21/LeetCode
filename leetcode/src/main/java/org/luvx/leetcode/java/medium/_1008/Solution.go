package main

import (
	"fmt"

	. "foobar/common/src/main/golang"
)

/*
 * @lc app=leetcode.cn id=1008 lang=golang
 *
 * [1008] 前序遍历构造二叉搜索树
 */

// @lc code=start
// 无重复元素的BST的前序遍历能唯一确定一个BST
func bstFromPreorder(preorder []int) *TreeNode {
	return tree(preorder, 0, len(preorder)-1)
}
func tree(preorder []int, left, right int) *TreeNode {
	if left > right {
		return nil
	}

	mid := preorder[left]
	root := &TreeNode{Val: mid}
	if left == right {
		return root
	}

	i := left
	for ; i < right; i++ {
		if i+1 < len(preorder) && preorder[i+1] > mid {
			break
		}
	}
	root.Left = tree(preorder, left+1, i)
	if i < right {
		root.Right = tree(preorder, i+1, right)
	}

	return root
}

// @lc code=end
func main() {
	// array := []int{8, 5, 1, 7, 10, 12}
	array := []int{1, 3}
	root := bstFromPreorder(array)
	fmt.Println(root)
}
