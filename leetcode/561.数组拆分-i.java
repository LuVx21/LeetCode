/*
 * @lc app=leetcode.cn id=561 lang=java
 *
 * [561] 数组拆分 I
 */

// @lc code=start
class Solution {
    public int arrayPairSum(int[] nums) {
        int[] arr = new int[20_001];
        for (int num : nums) {
            arr[num + 10_000]++;
        }
        int tag = 1, sum = 0;
        for (int i = -10_000; i <= 10_000; i++) {
            final int i1 = arr[i + 10_000] + tag;
            sum += i1 / 2 * i;
            tag = i1 & 1;
        }
        return sum;
    }

    public int arrayPairSum1(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
// @lc code=end

