/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */
class Solution {
    /**
     * 实现 int sqrt(int x) 函数.
     * 计算并返回 x 的平方根, 其中 x 是非负整数.
     * 由于返回类型是整数, 结果只保留整数的部分, 小数部分将被舍去.
     *
     * 牛顿迭代法:
     * x的平方根即是r*r-x=0的正解
     */
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}

