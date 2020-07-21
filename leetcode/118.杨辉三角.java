/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    /**
     * <pre>
     *      1
     *     1 1
     *    1 2 1
     *   1 3 3 1
     *  1 4 6 4 1
     * 1 5 10 10 5 1
     * </pre>
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> data = new ArrayList<>(numRows);

        //<editor-fold desc="方式0">
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < i; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            data.add(new ArrayList<>(row));
        }
        //</editor-fold>

        //<editor-fold desc="方式1">
        /*for (int i = 0; i < numRows; i++) {
            List<Integer> r = new ArrayList(i);
            for (int j = 0; j <= i; j++) {
                r.add(1);
            }
            data.add(r);
        }

        for (int level = 2; level < numRows; level++) {
            List<Integer> pre = data.get(level - 1), cur = data.get(level);
            for (int i = 1; i <= level - 1; i++) {
                cur.set(i, pre.get(i - 1) + pre.get(i));
            }
        }*/
        //</editor-fold>

        return data;
    }
}
// @lc code=end

