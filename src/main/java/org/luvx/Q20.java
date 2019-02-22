import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (36.02%)
 * Total Accepted:    42.5K
 * Total Submissions: 118K
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 * 
 * 注意空字符串可被认为是有效字符串。
 * 
 * 示例 1:
 * 
 * 输入: "()"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: "()[]{}"
 * 输出: true
 * 
 * 
 * 示例 3:
 * 
 * 输入: "(]"
 * 输出: false
 * 
 * 
 * 示例 4:
 * 
 * 输入: "([)]"
 * 输出: false
 * 
 * 
 * 示例 5:
 * 
 * 输入: "{[]}"
 * 输出: true
 * 
 */
class Q20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            Character top = stack.peek();
            Character in = s.charAt(i);
            if (isP(top, in)) {
                stack.pop();
            } else {
                stack.push(in);
            }
        }
        return stack.isEmpty();
    }
    public boolean isP(Character c1, Character c2) {
        if ((c1.equals('(') && c2.equals(')'))
                || (c1.equals(')') && c2.equals('(')) ||
                (c1.equals('[') && c2.equals(']'))
                || (c1.equals(']') && c2.equals('[')) ||
                (c1.equals('{') && c2.equals('}'))
                || (c1.equals('}') && c2.equals('{'))
        ) {
            return true;
        } else {
            return false;
        }
    }
}
