import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */
class Solution {
    /**
     * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
     * <p>
     * [1,12,-5,-6,50,3], k = 4
     * 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
     */
    public double findMaxAverage(int[] nums, int k) {
        return method0(nums, k);
    }

    /**
     * 滑动窗口
     * 30000 * 10000 小于int最大值
     */
    public double method00(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 1; i <= nums.length - k; i++) {
            sum += nums[i + k - 1] - nums[i - 1];
            max = Math.max(max, sum);
        }
        return max / 1.0 / k;
    }

    /**
     * 暴力匹配: O((n-k+1)*(k-1))
     */
    public double method0(int[] nums, int k) {
        int[] array = new int[nums.length - k + 1];
        for (int i = 0; i < array.length; i++) {
            int sum = nums[i];
            for (int j = 1; j < k; j++) {
                sum += nums[i + j];
            }
            array[i] = sum;
        }
        double max = Arrays.stream(array).max().getAsInt();
        return max / k;
    }

    public static void main(String[] args) {
        int[] a = {1, 12, -5, -6, 50, 3};
        System.out.println(exec.findMaxAverage(a, 4));
    }
}
