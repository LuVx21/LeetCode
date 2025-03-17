package common

import (
	"fmt"
	"testing"
)

func Test_222(t *testing.T) {
	root := NewCBT(1, 2, 3, 4, 5, 6)
	fmt.Println(root.String())
}
