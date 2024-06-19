package org.luvx.leetcode.java.medium._150;
/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

import java.util.Set;

// @lc code=start
class Solution {
    Set<String> token = Set.of("+", "-", "*", "/");

    /**
     * ["2","1","+","3","*"] -> 9
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }

        int[] stack = new int[tokens.length];
        int index = -1;
        int r = 0;
        for (String t : tokens) {
            if (token.contains(t) && index >= 1) {
                int second = stack[index--];
                int first = stack[index--];
                r = com(t, first, second);
                stack[++index] = r;
                continue;
            }
            stack[++index] = Integer.parseInt(t);
        }

        return r;
    }

    int com(String token, int a, int b) {
        return switch (token) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }
}
// @lc code=end
