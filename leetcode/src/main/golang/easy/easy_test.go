package easy

import (
	"cmp"
	"fmt"

	"github.com/luvx21/coding-go/coding-common/tree"

	"testing"

	"github.com/emirpasic/gods/v2/lists/arraylist"
)

func Test_oo(t *testing.T) {
	list := arraylist.New[string]()
	list.Add("a")                         // ["a"]
	list.Add("c", "b")                    // ["a","c","b"]
	list.Sort(cmp.Compare[string])        // ["a","b","c"]
	_, _ = list.Get(0)                    // "a",true
	_, _ = list.Get(100)                  // nil,false
	_ = list.Contains("a", "b", "c")      // true
	_ = list.Contains("a", "b", "c", "d") // false
	list.Swap(0, 1)                       // ["b","a",c"]
	list.Remove(2)                        // ["b","a"]
	list.Remove(1)                        // ["b"]
	list.Remove(0)                        // []
	list.Remove(0)                        // [] (ignored)
	_ = list.Empty()                      // true
	_ = list.Size()                       // 0
	list.Add("a")                         // ["a"]
	fmt.Println(list.Values())            // ["a"]
	list.Clear()                          // []
}

func Test_222(t *testing.T) {
	root := tree.NewCBT(1, 2, 3, 4, 5, 6)
	root1 := tree.NewCBT[int]()
	fmt.Println(countNodes(root))
	fmt.Println(countNodes(root1))

	fmt.Println(countNodes1(root))
	fmt.Println(countNodes1(root1))
}

func Test_278(t *testing.T) {
	fmt.Println(firstBadVersion(5))
}

func Test_744(t *testing.T) {
	// r := nextGreatestLetter([]byte{'c', 'f', 'j'}, 'a')
	r := nextGreatestLetter([]byte{'x', 'x', 'y', 'y'}, 'z')
	fmt.Println(string(r))
}
