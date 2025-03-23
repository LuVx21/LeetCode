package tree

import (
	"fmt"
	"testing"

	"github.com/luvx21/coding-go/coding-common/tree"
)

func Test_222(t *testing.T) {
	root := tree.NewCBT(1, 2, 3, 4, 5, 6)
	fmt.Println(root.String())
}
