package org.luvx.leetcode.java.medium._287;
/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

import java.util.List;

// @lc code=start
class Solution {
    /**
     * 思路和寻找链表环入口(leetcode-142)一致
     * 举个例子：nums = [2,5,9,6,9,3,8,9,7,1]
     * 构造成链表就是：2->[9]->1->5->3->6->8->7->[9]，也就是在[9]处循环。
     * <pre>
     *     3,4,1,2,2 -> 2
     * </pre>
     * 题解: https://leetcode-cn.com/problems/find-the-duplicate-number/comments/33529
     */
    public int findDuplicate(int[] nums) {
        int res = 0;
        for (int fast = 0; fast == 0 || res != fast; ) {
            res = nums[res];
            fast = nums[nums[fast]];
        }
        for (int i = 0; res != i; i = nums[i]) {
            res = nums[res];
        }
        return res;
    }

    public int findDuplicate1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            if (slow == nums[slow]) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            if (slow == nums[slow]) {
                return slow;
            }
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate0(int[] nums) {
        byte[] array = new byte[100001];
        for (int num : nums) {
            byte b = array[num];
            if (b == 1) {
                return num;
            }
            array[num] = 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        List.of(
                new int[] {3, 4, 1, 2, 2},
                new int[] {2, 5, 9, 6, 9, 3, 8, 9, 7, 1}
        ).forEach(array ->
                System.out.println(exec.findDuplicate(array))
        );
    }
}
// @lc code=end

