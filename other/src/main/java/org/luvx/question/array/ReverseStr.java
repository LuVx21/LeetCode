package org.luvx.question.array;

import org.apache.commons.lang3.ArrayUtils;

public class ReverseStr {
    /**
     * 类似 leetcode-541
     * 每 k 个字符进行反转
     * 8 - 3
     * <pre>
     *     abc def gh, 3
     *     cba fed hg
     * </pre>
     */
    public String reverseStr(String str, int k) {
        if (str == null) {
            return "";
        }
        char[] array = str.toCharArray();
        int slow = 0, fast = 0;
        while (fast < array.length) {
            for (int i = 0; i < Math.min(array.length, k) - 1 && fast < array.length - 1; i++) {
                fast++;
            }
            for (int left = slow, right = fast; left < right; ) {
                ArrayUtils.swap(array, left++, right--);
            }
            fast = slow = fast + 1;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        ReverseStr exec = new ReverseStr();
        System.out.println(exec.reverseStr("abcdefgh", 10));
    }
}
