/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 *
 * https://leetcode-cn.com/problems/count-and-say/description/
 *
 * algorithms
 * Easy (47.60%)
 * Total Accepted:    19.6K
 * Total Submissions: 41.2K
 * Testcase Example:  '1'
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 
 * 
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 
 * 注意：整数顺序将表示为一个字符串。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 1
 * 输出: "1"
 * 
 * 
 * 示例 2:
 * 
 * 输入: 4
 * 输出: "1211"
 * 
 * 
 */
/**
1.     1
2.     11
3.     21
4.     1211
5.     111221
6.     312211
7.     13112221
8.     1113213211
  */
class Q38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }

        String result = "11";
        for (int i = 3; i <= n; i++) {
            String temp = "";
            int count = 1;
            System.out.println("temp:" + temp);
            for (int j = 0; j < result.length() - 1; j++) {
                if (result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    if (j == result.length() - 2) {
                        temp += "" + count + result.charAt(j);
                    }
                    continue;
                } else {
                    temp += "" + count + result.charAt(j);
                    if (j == result.length() - 2) {
                        temp += "" + "1" + result.charAt(j + 1);
                    }
                    count = 1;
                }
            }
            result = temp;
        }

        return result;
    }
    // 找出所有连续的串
}
