package org.luvx.remember._string;

public class Main {

    /**
     * 删除字符串中重复字符(重复的保留一个)
     */
    public String removeDuplicateLetters(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }

    void main() {
    }
}

