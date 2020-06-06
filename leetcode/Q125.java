/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 *
 * https://leetcode-cn.com/problems/valid-palindrome/description/
 *
 * algorithms
 * Easy (37.67%)
 * Total Accepted:    21.6K
 * Total Submissions: 57.3K
 * Testcase Example:  '"A man, a plan, a canal: Panama"'
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 */
class Q125 {
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
