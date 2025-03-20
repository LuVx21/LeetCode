package link

import (
	"strconv"
	"strings"

	"github.com/luvx21/coding-go/coding-common/common_x"
)

// ListNode 链表
type ListNode struct {
	Val  int
	Next *ListNode
}

func (h *ListNode) String() string {
	var sb strings.Builder
	for h != nil {
		sb.WriteString(strconv.Itoa(h.Val) + common_x.IfThen(h.Next == nil, "", "->"))
		h = h.Next
	}
	sb.WriteString("\n--------------")
	return sb.String()
}
