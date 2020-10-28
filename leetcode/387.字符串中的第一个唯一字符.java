/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     * loveleetcode
     *   2
     * </pre>
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int len = s.length();
        if (len == 1) {
            return 0;
        }
        int[] array = new int[26];
        for (int i = 0; i < len; i++) {
            int k = s.charAt(i) - 97;
            array[k] = array[k] + 1;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                set.add((char) (i + 97));
            }
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

