package org.luvx.question.string;

import org.luvx.common.more.MoreRuns;

public class String1 {
    /**
     * 去除字符串中的连续重复, 只保留一个
     */
    private String filter(String s) {
        int len;
        if (s == null || (len = s.length()) == 0 || len == 1) {
            return s;
        }
        char[] array = s.toCharArray();
        int start = len - 1;
        for (int j = start - 1; j >= 0; ) {
            while (j >= 0 && array[j] == array[start]) {
                j--;
            }
            if (j < 0) {
                break;
            }
            array[--start] = array[j--];
        }
        return new String(array, start, s.length() - start);
    }

    public static void main(String[] args) {
        MoreRuns.run(String1.class, "filter", "bbcb", "abcdefffg", "aaaaa");
    }
}