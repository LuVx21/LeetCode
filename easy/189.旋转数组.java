/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {

    /**
     * 环形
     * <pre>
     *     1 2 3 4 5 6
     *     5 6 1 2 3 4
     * </pre>
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        final int len = nums.length;
        k %= len;
        if (k == 0) {
            return;
        }
        // 1, 2
        int cnt = 0;
        for (int i = 0; cnt < len; i++) {
            int curIndex = i, prev = nums[i];
            do {
                int movedIndex = (curIndex + k) % len;
                int temp = nums[movedIndex];
                nums[movedIndex] = prev;
                prev = temp;
                curIndex = movedIndex;
                cnt++;
            } while (i != curIndex);
        }
    }

    /**
     * 反转(3次)
     * <pre>
     *   0: 1, 2, 3, 4
     *   1: 4, 3, 2, 1
     *   2: 3, 4, 2, 1
     *   3: 3, 4, 1, 2
     *
     *     1, 2, 3, 4, 5, 6, 7
     *     ↓ 3
     *     5, 6, 7, 1, 2, 3, 4
     * </pre>
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if (len == 0) {
            return;
        }

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    /**
     * @param array 数组
     * @param start 下标起点
     * @param end   下标终点
     */
    private void reverse(int[] array, int start, int end) {
        int len = end - start + 1;
        for (int i = start; i < start + (len / 2); i++) {
            int temp = array[start + end - i];
            array[start + end - i] = array[i];
            array[i] = temp;
        }
    }

    /**
     * 逐个挪
     *
     * @param nums
     * @param k
     */
    public void rotate0(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        for (int i = 0; i < k; i++) {
            int value = nums[len - 1];
            for (int j = len - 2; j >= 0; j--) {
                nums[j + 1] = nums[j];
            }
            nums[0] = value;
        }
    }
}
// @lc code=end

