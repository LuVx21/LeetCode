/*
 * @lc app=leetcode.cn id=167 lang=java
 *
 * [167] 两数之和 II - 输入有序数组
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashSet<Integer> set = new HashSet<>(numbers.length);
        for (int i : numbers) {
            set.add(Integer.valueOf(i));
        }

        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            if (set.contains(Integer.valueOf(target - a))) {
                for (int j = i + 1; j < numbers.length; j++) {
                    if (target - a == numbers[j]) {
                        return new int[]{i + 1, j + 1};
                    }
                }
            }
        }

        return new int[0];
    }

    public int[] twoSum1(int[] numbers, int target) {
        aa:
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for (int j = numbers.length - 1; j > i; j--) {
                int b = numbers[j];
                if (a + b < target) {
                    continue aa;
                } else if (a + b > target) {
                    continue;
                } else {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[0];
    }
}
// @lc code=end

