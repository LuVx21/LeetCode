/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */
class Solution {

    /**
     * 方式3
     * "  the sky  is blue  " -> 异常
     * ↓
     * blud is sky the
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length(), i = len - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }
            sb.append(" ");
            sb.append(s, j + i, i + 1);
            i = j - 1;
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }

    /**
     * 方式2
     * "  the sky  is blue  "
     * ↓
     * blud is sky the
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length(), i = 0;
        int start = 0;
        while (i < len) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            int j = i - 1;
            if (j >= 0 && s.charAt(j) == ' ') {
                start = i;
                i++;
                continue;
            }
            int k = i + 1;
            if (k < len && s.charAt(k) == ' ') {
                sb.insert(0, sb.length() == 0 ? "" : " ");
                sb.insert(0, s, start, i + 1);
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * 方式1
     */
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] array = s.split(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            String s1 = array[i];
            if (!Objects.equals(s1, "")) {
                sb.append(s1);
                if (i != 0) {
                    sb.append(" ");
                }
            }
        }
        if (sb.length() == 0) {
            return "";
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}

