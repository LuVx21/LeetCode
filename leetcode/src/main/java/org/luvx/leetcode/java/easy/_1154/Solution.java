package org.luvx.leetcode.java.easy._1154;

/*
 * @lc app=leetcode.cn id=1154 lang=java
 *
 * [1154] 一年中的第几天
 */

// @lc code=start

import java.time.LocalDate;

class Solution {
    /**
     * 2019-01-09 -> 9
     * 2019-02-10 -> 41
     */
    public int dayOfYear(String date) {
        return LocalDate.parse(date).getDayOfYear();
        // int year = Integer.parseInt(date, 0, 4, 10);
        // int month = Integer.parseInt(date, 5, 7, 10);
        // int day = Integer.parseInt(date, 8, 10, 10);
        // return 0;
    }
}
// @lc code=end
