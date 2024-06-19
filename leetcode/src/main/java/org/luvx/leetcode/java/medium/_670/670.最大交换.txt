/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */
class Solution {
    /**
     * 98368 -> 98863
     * 1993 -> 9913
     * 99901 -> 99910
     * <p>
     * 670: 最多互换一组字符可以得到的最大数字
     * <p>
     * 最后一次出现的最大的和第一个最小的数字交换
     */
    public int maximumSwap(int num) {
        String s = num + "";
        int start = 0, max = start, len = s.length();
        for (; start < len; start++) {
            max = start;
            for (int i = start + 1; i < len; i++) {
                if (s.charAt(i) >= s.charAt(max)) {
                    max = i;
                }
            }
            if (max != start && s.charAt(max) != s.charAt(start)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = start; i < max; i++) {
            if (s.charAt(i) < s.charAt(max)) {
                sb.setCharAt(i, s.charAt(max));
                sb.setCharAt(max, s.charAt(i));
                break;
            }
        }
        return Integer.valueOf(sb.toString());
    }
}

