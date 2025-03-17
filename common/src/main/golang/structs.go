package common

import (
	"math"
	"strings"
)

// ListNode 链表
type ListNode struct {
	Val  int
	Next *ListNode
}

// TreeNode 二叉树
type TreeNode struct {
	Val         int
	Left, Right *TreeNode
}

func (root *TreeNode) IsLeaf() bool {
	return root.Left == nil && root.Right == nil
}

func (root *TreeNode) String() string {
	if root == nil {
		return ""
	}

	levelRows := make([][]int, 0, 0)
	queue := make([]*TreeNode, 0, 0)

	for k := 0; len(queue) > 0; k++ {
		var isBreak bool = true
		size := len(queue)
		row := make([]int, 0, 0)
		for i := 0; i < size; i++ {
			node := queue[len(queue)-1]
			queue = queue[:len(queue)-1]
			if node == nil {
				row = append(row, math.MinInt)
				queue = append(queue, nil, nil)
			} else {
				isBreak = isBreak && node.IsLeaf()
				row = append(row, node.Val)
				queue = append(queue, node.Left, node.Right)
			}
		}
		levelRows = append(levelRows, row)
		if isBreak {
			break
		}
	}
	line := strings.Repeat("-", 150)
	sb := dumpTreeFormat0(levelRows)
	sb.WriteString(line)
	sb.WriteString("\n")
	sb.WriteString(dumpTreeFormat(levelRows))
	sb.WriteString(line)
	sb.WriteString("\n")
	return sb.String()
}

func dumpTreeFormat0(rows [][]int) strings.Builder {
	var sb strings.Builder
	return sb
}
func dumpTreeFormat(rows [][]int) string {
	return ""
}

// Node N叉树
type Node struct {
	Val      int
	Children []*Node
}

func NewCBT(arr ...int) *TreeNode {
	_len := len(arr)
	if _len == 0 {
		panic("不能使用空数组构建二叉树")
	}
	if _len == 1 {
		return &TreeNode{Val: arr[0]}
	}
	list := make([]*TreeNode, _len)
	for i, v := range arr {
		if v <= math.MinInt {
			continue
		}
		list[i] = &TreeNode{Val: v}
	}
	for i := 0; 2*i+1 < _len; i++ {
		n := list[i]
		if n == nil {
			continue
		}
		n.Left = list[2*i+1]
		if 2*i+2 < _len {
			n.Right = list[2*i+2]
		}
	}
	return list[0]
}
