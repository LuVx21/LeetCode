package org.luvx.question.string;

import java.util.List;
import java.util.Stack;

public class Q2 {
    /**
     * 合法括号序列判断
     * 给定一个字符串A，请返回一个bool值代表它是否为一个合法的括号串（只能由括号组成）。
     * <pre>
     *     (()()) -> true
     *     ()a()() -> false
     *     ()(()() -> ( -> false
     *     ())()()(((d -> )(((d -> false
     * </pre>
     */
    public boolean chkParenthesis(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c != '(' && c != ')') {
                return false;
            }
            cnt += (c == '(' ? 1 : -1);
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

    public boolean chkParenthesis1(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                return false;
            }
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    /**
     * Map<()>
     * <)(>
     */
    public static void main(String[] args) {
        final Q2 exec = new Q2();
        List.of("(()())",
                "()a()()",
                "()(()()",
                "())()()(((d",
                "))(())"
        ).forEach(s -> System.out.println(exec.chkParenthesis(s)));
    }
}