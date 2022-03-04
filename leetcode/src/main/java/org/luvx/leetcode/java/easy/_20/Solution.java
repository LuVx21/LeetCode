package org.luvx.leetcode.java.easy._20;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Stack;

class Solution {
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
        return (c1.equals('(') && c2.equals(')'))
                || (c1.equals(')') && c2.equals('(')) ||
                (c1.equals('[') && c2.equals(']'))
                || (c1.equals(']') && c2.equals('[')) ||
                (c1.equals('{') && c2.equals('}'))
                || (c1.equals('}') && c2.equals('{'));
    }
}
// @lc code=end

