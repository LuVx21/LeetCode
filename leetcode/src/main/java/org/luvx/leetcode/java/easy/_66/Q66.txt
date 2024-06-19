/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (37.05%)
 * Total Accepted:    34.3K
 * Total Submissions: 92.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */
class Q66 {
    public int[] plusOne(int[] digits) {
        if (digits[0] == 0) {
            int[] array = {1};
            return array;
        }
        int length = digits.length;
        int index = length - 1;
        int temp = ++digits[length - 1];

        while (temp >= 10) {
            if (index == 0) {
                digits = new int[length + 1];
                index++;
            }
            digits[index] = temp - 10;
            temp = ++digits[index - 1];
            index--;
        }

        return digits;
    }
}
