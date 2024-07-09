package org.luvx.leetcode.java.easy._520;
/*
 * @lc app=leetcode.cn id=520 lang=java
 *
 * [520] 检测大写字母
 */

import java.util.stream.Stream;

// @lc code=start
class Solution {
    public boolean detectCapitalUse(String word) {
        int cnt = 0;
        byte[] bytes = word.getBytes();
        for (byte c : bytes) {
            if (isUpper(c)) {
                cnt++;
            }
        }
        return cnt == 0 || cnt == word.length() || cnt == 1 && isUpper(bytes[0]);
    }

    public boolean detectCapitalUse0(String word) {
        if (word.length() == 1) {
            return true;
        }
        byte[] bytes = word.getBytes();
        boolean isUpper0 = isUpper(bytes[0]), isUpper1 = isUpper(bytes[1]);
        for (int i = 2; i < bytes.length; i++) {
            boolean upper = isUpper(bytes[i]);
            if (isUpper1 != upper) {
                return false;
            }
        }
        return isUpper0 || !isUpper1;
    }

    boolean isUpper(byte b) {
        return b >= 'A' && b <= 'Z';
    }

    void main() {
        Stream.of("USA", "leetcode", "Google", "aBBBBB", "FlaG")
                .map(this::detectCapitalUse)
                .forEachOrdered(System.out::println);
    }
}
// @lc code=end
