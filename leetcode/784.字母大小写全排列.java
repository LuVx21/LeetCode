/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */
class Solution {
    public List<String> letterCasePermutation(String S) {
        if (S.length() == 0) {
            return null;
        }

        List<String> result = new ArrayList<>();
        char[] array = S.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];

            if (c >= 65 && c <= 90) {
                if (result.size() == 0) {
                    result.add(String.valueOf(c));
                    result.add(String.valueOf((char) (c + 32)));
                } else {
                    List<String> a = new ArrayList<>();
                    for (int j = 0; j < result.size(); j++) {
                        String str = result.get(j);
                        result.set(j, str + c);
                        a.add(str + (char) (c + 32));
                    }
                    result.addAll(a);
                }
            } else if (c >= 97 && c <= 122) {
                if (result.size() == 0) {
                    result.add(String.valueOf(c));
                    result.add(String.valueOf((char) (c - 32)));
                } else {
                    List<String> a = new ArrayList<>();
                    for (int j = 0; j < result.size(); j++) {
                        String str = result.get(j);
                        result.set(j, str + c);
                        a.add(str + (char) (c - 32));
                    }
                    result.addAll(a);
                }
            } else {
                if (result.size() == 0) {
                    result.add(String.valueOf(c));
                } else {
                    for (int j = 0; j < result.size(); j++) {
                        result.set(j, result.get(j) + c);
                    }
                }
            }
        }

        return result;
    }
}

