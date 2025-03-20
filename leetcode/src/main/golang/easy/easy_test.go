package easy

import (
	"cmp"
	"fmt"
	common "foobar/common/src/main/golang"
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
	root := common.NewCBT(1, 2, 3, 4, 5, 6)
	root1 := common.NewCBT()
	fmt.Println(countNodes(root))
	fmt.Println(countNodes(root1))
}

func Test_278(t *testing.T) {
	fmt.Println(firstBadVersion(0))
}
