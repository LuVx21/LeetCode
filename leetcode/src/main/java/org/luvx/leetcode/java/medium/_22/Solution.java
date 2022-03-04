package org.luvx.leetcode.java.medium._22;
/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * 有点难
     * <pre>
     *     1: ()
     *     2: ()() (())
     *     3: ()()() (()()) (())() ()(()) ((()))
     * </pre>
     */
    List[] cache = new ArrayList[100];

    public List<String> generateParenthesis0(int n) {
        return generate(n);
    }

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : generate(i)) {
                    for (String right : generate(n - 1 - i)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrack(List<String> list, StringBuilder str, int open, int close, int max) {
        if (str.length() == max * 2) {
            list.add(str.toString());
            return;
        }
        if (open < max) {
            str.append('(');
            backtrack(list, str, open + 1, close, max);
            str.deleteCharAt(str.length() - 1);
        }
        if (close < open) {
            str.append(')');
            backtrack(list, str, open, close + 1, max);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution exec = new Solution();
        System.out.println(exec.generateParenthesis(1));
    }
}
// @lc code=end

