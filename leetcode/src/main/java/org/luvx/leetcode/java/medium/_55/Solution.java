package org.luvx.leetcode.java.medium._55;
/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    /**
     * 回溯法->带记忆表的回溯法—->动态规划->贪心
     * <pre>
     *     2,0,1,1,4 -> true
     *     2,3,1,1,4 -> true
     *     3,2,1,0,4 -> false
     * </pre>
     * #贪心
     */
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0, len = nums.length; i < len; i++) {
            if (i > reachable) {
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public boolean canJump3(int[] nums) {
        // 跳到`右边第一个能跳到最后的位置`的最少需要跳过的个数
        int min = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= min) {
                // 对于i-1, 只需能跳1个到i位置就行
                min = 1;
            } else {
                // i位置跳不到`右边第一个能跳到最后的位置`,需跳过的步幅加1
                min++;
            }
            // 最左边,min>1表示nums[0]<min, 即0跳不到`右边第一个能跳到最后的位置`
            if (i == 0 && min > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划-优化
     */
    public boolean canJump2(int[] nums) {
        // 能跳到最后的最小下标
        int can = nums.length - 1;

        // 从叶子节点往上倒推，并把有解的记录下来。
        for (int i = nums.length - 2; i >= 0; i--) {
            var furthest = Math.min(nums[i] + i, nums.length - 1);
            // [i+1, furthest]
            if (can <= furthest) {
                can = i;
            }
        }
        return can == 0;
    }

    /**
     * 动态规划
     */
    public boolean canJump1(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;

        // 从叶子节点往上倒推，并把有解的记录下来。
        for (int i = nums.length - 2; i >= 0; i--) {
            var furthest = Math.min(nums[i] + i, nums.length - 1);
            for (int j = i + 1; j <= furthest; j++) {
                if (dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    /**
     * 回溯法
     */
    public boolean canJump0(int[] nums) {
        return backtrack(nums, 0);
    }

    private boolean backtrack(int[] nums, int pos) {
        // 如果到达叶子节点（已知解），那么一定可以到达。
        if (pos == nums.length - 1) {
            return true;
        }

        // 对当前节点进行扩展，推导它的子节点。
        var furthest = Math.min(nums[pos] + pos, nums.length - 1);
        // 当前节点所能跳的范围[pos+1, furthest],挨个试一遍
        for (int i = pos + 1; i <= furthest; i++) {
            if (backtrack(nums, i)) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

