package org.luvx.leetcode.java.easy._125;
/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0, j = length - 1; i <= j; ) {
            if (!isAlpOrNum(s.charAt(i))) {
                System.out.println(i);
                System.out.println(s.charAt(i));

                System.out.println("aaaa");
                i++;
                continue;
            }
            if (!isAlpOrNum(s.charAt(j))) {
                System.out.println("bbbb");
                j--;
                continue;
            }

            Character left = new Character(s.charAt(i));
            Character right = new Character(s.charAt(j));
            if (left.equals(right)) {
                if (i == j) {
                    return true;
                }
                i++;
                j--;
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    private static boolean isAlpOrNum(char c) {
        if (
                (c >= 48 && c <= 57)
                        || (c >= 65 && c <= 90)
                        || (c >= 97 && c <= 122)
        ) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

