/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    /**
     * 效率不如下面的高
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
            System.out.println(slow + ":" + fast);
        } while (slow != fast);
        return slow == 1;
    }

    int digitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy1(int n) {
        if (n <= 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        for (; ; ) {
            int sum = 0;
            while (n != 0) {
                sum += ((n % 10) * (n % 10));
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(n = sum);
        }
    }
}
// @lc code=end
