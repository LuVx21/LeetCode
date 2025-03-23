package easy

/*
 * @lc app=leetcode.cn id=796 lang=golang
 *
 * [796] 旋转字符串
 */

// @lc code=start
func rotateString(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	// return strings.Contains(strings.Repeat(s, 2), goal)

	i, len := 0, len(s)
	for i < 2*len {
		if s[i%len] != goal[0] {
			i++
			continue
		}
		start, next, j := i, -1, 0
		for j < len && s[i%len] == goal[j] {
			if start != i && next == -1 && s[i%len] == goal[0] {
				next = i
			}
			i++
			j++
		}
		if j == len {
			return true
		}
		if next == -1 {
			next = start + j
		}
		i = next
	}
	return false
}

// @lc code=end
