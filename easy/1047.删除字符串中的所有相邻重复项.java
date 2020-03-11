/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    /**
     * 1. 新建数组模拟队列, 放入数组前先和数组最后的比较, 重复则不放入并移除已放入的那个
     * 2. 1中不使用数组, 使用 StringBuilder
     * 3. 双向队列
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        int length = S.length();
        char[] array = new char[length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (S.charAt(i) != array[index]) {
                array[++index] = S.charAt(i);
            } else {
                index--;
            }
        }

        return new StringBuilder().append(array, 1, index).toString();
    }
}
// @lc code=end

