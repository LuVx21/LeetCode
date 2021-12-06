/*
 * @lc app=leetcode.cn id=119 lang=java
 *
 * [119] 杨辉三角 II
 */

// @lc code=start
class Solution {
    /**
     * O(n) 空间复杂度
     * <pre>
     *       1
     *      1 1
     *     1 2 1
     *    1 3 3 1
     *   1 4 6 4 1
     *  1 5 10 10 5 1
     * 1 6 15 20 15 6 1
     * </pre>
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> data = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            data.add(1);
        }

        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                data.set(j, data.get(j - 1) + data.get(j));
            }
        }
        return data;
    }
}
// @lc code=end

