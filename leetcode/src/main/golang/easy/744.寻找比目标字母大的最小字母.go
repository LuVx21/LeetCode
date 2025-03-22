package easy

/*
 * @lc app=leetcode.cn id=744 lang=golang
 *
 * [744] 寻找比目标字母大的最小字母
 */

// @lc code=start
func nextGreatestLetter(letters []byte, target byte) byte {
	if target >= letters[len(letters)-1] {
		return letters[0]
	}

	index := [26]uint8{}
	for _, item := range letters {
		index[item-'a'] += 1
	}

	for i := target - 'a' + 1; i < 26; i++ {
		if index[i] > 0 {
			return byte(i + 'a')
		}
	}
	return letters[0]
}

// @lc code=end
