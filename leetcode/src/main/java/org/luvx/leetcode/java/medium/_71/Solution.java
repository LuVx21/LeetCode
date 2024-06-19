package org.luvx.leetcode.java.medium._71;
/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// @lc code=start
class Solution {
    final Set<String> skip = Set.of("..", ".", "");

    /**
     * "/a/./b//../../c/" -> "/c"
     */
    public String simplifyPath(String path) {
        final String separator = "/";

        String[] split = path.split(separator);
        int index = -1;
        String[] stack = new String[split.length];
        for (String dir : split) {
            if (dir.equals("..") && index >= 0) {
                stack[index--] = null;
            } else if (!skip.contains(dir)) {
                stack[++index] = dir;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            if (dir != null) {
                sb.append(separator).append(dir);
            }
        }
        return sb.isEmpty() ? separator : sb.toString();
    }

    /**
     * <pre>
     * 01234567890123456789
     * /a/../../b/../c//.// -> /c
     * /a//b////c/d//././/.. -> /a/b/c
     * </pre>
     * 逆序读取, 放入栈, 遍历栈
     * 顺序读取, 放入队列, 遍历队列
     * "/"后可能为"/",".","..","字母"
     * split方法以/分割, 拼接为StringBuilder
     */
    public String simplifyPath1(String path) {
        List<String> list = new ArrayList<>();
        int len = path.length(), pre = 0;
        for (int i = 1; i < len; i++) {
            if (path.charAt(i) == '/' || i == len - 1) {
                int end = i;
                if ((i == len - 1) && path.charAt(i) != '/') {
                    end = len;
                }
                String s = path.substring(pre + 1, end);
                System.out.println(i + ":" + s);
                if (s.equals("..")) {
                    if (!list.isEmpty()) {
                        list.removeLast();
                    }
                } else if (s.equals(".") || s.equals("")) {
                } else {
                    list.add(s);
                }
                pre = i;
            }
        }
        return "/" + String.join("/", list);
    }
}
// @lc code=end

