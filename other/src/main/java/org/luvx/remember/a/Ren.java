package org.luvx.remember.a;

public class Ren {

    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
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
}

