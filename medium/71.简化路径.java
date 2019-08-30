import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */
class Solution {

    public String simplifyPath(String path) {
        final String separator = "/";
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split(separator)) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String res = "";
        for (String dir : stack) {
            res = separator + dir + res;
        }
        return res.isEmpty() ? separator : res;
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
                    if (list.size() != 0) {
                        list.remove(list.size() - 1);
                    }
                } else if (s.equals(".") || s.equals("")) {
                } else {
                    list.add(s);
                }
                pre = i;
            }
        }
        return "/" + list.stream().collect(Collectors.joining("/"));
    }
}

