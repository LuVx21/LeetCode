/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int[] arr1 = arr.clone();
        Arrays.sort(arr1);
        Map<Integer, Integer> map = new HashMap<>(8);
        int num = 1;
        for (int v : arr1) {
            if (!map.containsKey(v)) {
                map.put(v, num++);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
// @lc code=end

