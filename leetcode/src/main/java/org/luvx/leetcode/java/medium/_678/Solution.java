package org.luvx.leetcode.java.medium._678;
/*
 * @lc app=leetcode.cn id=678 lang=java
 *
 * [678] 有效的括号字符串
 */

// @lc code=start

import java.util.List;
import java.util.Stack;

class Solution {
    /**
     * (*)) -> true
     * ((*) -> true
     * (*()) -> true
     * (*))((*)(*()) -> true
     */
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                high++;
                low++;
            } else if (c == ')') {
                high--;
                low--;
            } else if (c == '*') {
                high++;
                low--;
            }
            if (high < 0) {
                return false;
            }
            low = Math.max(low, 0);
        }
        return low == 0;
    }

    public boolean checkValidString1(String s) {
        if (s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '*') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.peek();
                if (top == '(') {
                    stack.pop();
                } else {
                    Stack<Character> s1 = new Stack<>();
                    while (!stack.isEmpty()) {
                        Character pop = stack.pop();
                        if (pop == '*') {
                            s1.push(pop);
                        }
                        if (pop == '(' || stack.isEmpty()) {
                            while (!s1.isEmpty()) {
                                stack.push(s1.pop());
                            }
                            if (pop != '(') {
                                stack.pop();
                            }
                            break;
                        }
                    }
                }
            }
        }

        // 处理栈内元素
        // (**  (**((**(*(*
        Stack<Character> s1 = new Stack<>();
        while (!stack.isEmpty()) {
            s1.push(stack.pop());
        }

        while (!s1.isEmpty()) {
            Character pop = s1.pop();
            if (pop == '(') {
                stack.push(pop);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        List.of("(*))", "((*)", "(*())", "(*))((*)(*())")
                .forEach(s -> System.out.println(exec.checkValidString(s)));
    }
}
// @lc code=end

