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
        /*
         *左括号的数量,分别为*作为右括号,*作为左括号时
         */
        int right = 0, left = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                right++;
            } else if (c == ')') {
                left--;
                right--;
            } else if (c == '*') {
                left++;
                right--;
            }
            // 此时数量: * 加 ( 小于 ), 之后有再多的*或(也无用了
            if (left < 0) {
                return false;
            }
            right = Math.max(right, 0);
        }
        return right == 0;
    }

    public boolean checkValidString0(String s) {
        Stack<Integer> left = new Stack<>(), star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left.push(i);
            } else if (s.charAt(i) == '*') {
                star.push(i);
            } else {
                if (left.empty() && star.empty()) {
                    return false;
                }
                (left.empty() ? star : left).pop();
            }
        }

        while (!left.empty() && !star.empty()) {
            if (left.peek() > star.peek()) {
                return false;
            }
            left.pop();
            star.pop();
        }
        return left.empty();
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

