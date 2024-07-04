package org.luvx.leetcode.java.medium._5;
/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    private int start, maxLen;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 找到更长的
        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }

    /**
     * MarsCode解释:
     * 使用 Manacher 算法来寻找一个给定字符串 s 中的最长回文子串。代码主要逻辑如下：
     * 1. 首先，调用 manacherStr 方法将原始字符串 s 转换为一个新的字符数组 array，在这个新字符数组中，每个字符之间都插入了一个特殊字符 $，这样做是为了处理回文串长度为奇数和偶数的情况。
     * 2. 然后，初始化两个变量 R 和 C 为 -1，这两个变量将保存找到的最长回文子串的半径和中心索引。
     * 3. 接着，创建一个长度与 array 相同的整数数组 radius，这个数组将保存以每个字符为中心的回文串半径。
     * 4. 再使用一个嵌套的循环来计算以每个字符为中心的回文串半径。对于每个字符 i，初始化半径为 1。如果当前字符 i 在已知的回文串的右边界之外（r > i），则可以利用对称性，通过中心索引 c 和当前索引 i 的关系计算出一个最小半径。然后，使用这个半径作为初始值，通过与字符数组 array 比较字符来扩展回文串。如果找到了更长的回文串，更新 R 和 C。
     * 5. 根据找到最长回文串的中心索引 C 和它的半径 R，可以计算出原始字符串 s 中的最长回文子串的起始索引 start 和结束索引 end。这里使用了位操作符 >> 1，即除以 2，来计算出 start 和 end。
     * 6. 最后，使用 s.substring(start, end) 来截取原始字符串 s 中的最长回文子串，并返回这个子串。
     * 总的来说，这段代码的时间复杂度为 $O(n^2)$，其中 $n$ 是原始字符串 s 的长度。此外，Manacher 算法利用了已有的计算结果，避免了不必要的重复计算，从而提高了效率。这种算法设计使得它在处理大量文本数据时非常有效，是解决回文串问题的理想选择。
     */
    public String longestPalindrome3(String s) {
        char[] array = manacherStr(s);

        // 最长回文子串的半径和中心索引
        int R = -1, C = -1;
        // 每个字符为中心的回文串半径
        int[] radius = new int[array.length];
        for (int i = 0, r = -1, c = -1; i < array.length; i++) {
            // 半径(默认为1)
            radius[i] = r > i ? Math.min(radius[c * 2 - i], r - i + 1) : 1;
            while (i - radius[i] >= 0 && i + radius[i] < array.length && array[i - radius[i]] == array[i + radius[i]]) {
                c = i;
                r = radius[i] + i;
                radius[i]++;
            }
            if (R < radius[i]) {
                R = radius[i];
                C = i;
            }
        }

        int start = (C - R + 1) >> 1, end = (C + R) >> 1;

        return s.substring(start, end);
    }

    /**
     * 最终的数组大小肯定是奇数
     * bcabad -> $b$c$a$b$a$d$
     * cac -> $c$a$c$
     */
    private char[] manacherStr(String s) {
        char[] array = s.toCharArray();
        int n = array.length;
        char[] r = new char[n << 1 | 1];
        for (int i = 0; i < n; i++) {
            r[i << 1] = '$';
            r[i << 1 | 1] = array[i];
        }
        r[n << 1] = '$';
        return r;
    }

    /**
     * 动态规划
     */
    public String longestPalindrome2(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // dp[i][j]: i到j是回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (boolean[] a : dp) {
            Arrays.fill(a, true);
        }

        int start = 0, max = 1;
        for (int left = 2; left <= s.length(); left++) {
            for (int i = 0; i < s.length(); i++) {
                int j = left + i - 1;
                if (j >= s.length()) {
                    break;
                }
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);

                int len = j - i + 1;
                if (dp[i][j] && len > max) {
                    max = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 记忆化搜索
     * <p>
     * 相比暴力方式, 效果不明显甚至有反效果
     */
    public String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        // 0:默认, -1: 不是, 1: 是
        int[][] memo = new int[s.length()][s.length()];
        int start = 0, max = 1;
        for (int i = 0; i < s.length() - max; i++) {
            for (int j = s.length() - 1; j >= i + max; j--) {
                int len = j - i + 1;
                if (isPalindrome(s, i, j, memo) && max < len) {
                    max = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 方法0: 暴力解法
     * <p>
     * 1. 针对i元素, 从后往前找, 找到最长的回文串, 记录下起始位置和长度
     * 2. 一直找到max前面的字符
     */
    public String longestPalindrome0(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int start = 0, max = 1;
        for (int i = 0; i < s.length() - max; i++) {
            for (int j = s.length() - 1; j >= i + max; j--) {
                int len = j - i + 1;
                if (isPalindrome(s, i, j, null) && max < len) {
                    max = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max);
    }

    /**
     * 判断是否为回文串
     */
    private boolean isPalindrome(String s, int start, int end, int[][] memo) {
        if (start == end) {
            return true;
        }
        // 不使用记忆化搜索
        if (memo == null) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }
        int v = memo[start][end];
        if (v != 0) {
            // 已经判断过了
            return v > 0;
        }

        memo[start][end] = -1;
        if (s.charAt(start) == s.charAt(end) && (end - start <= 1 || isPalindrome(s, start + 1, end - 1, memo))) {
            memo[start][end] = 1;
        }
        return memo[start][end] > 0;
    }

    public void main(String[] args) {
        List.of(
                        "", "a", "ac", "bbbbb", "bcabad",
                        "cbbd"
                        , "abccbefg"
                )
                .forEach(s -> {
                    System.out.println(s + "->" + new Solution().longestPalindrome3(s));
                });
    }
}
// @lc code=end
