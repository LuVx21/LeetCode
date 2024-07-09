package common

import (
    . "math"
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
        if v <= MinInt {
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
