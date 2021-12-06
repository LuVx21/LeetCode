/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */
class Solution {
    /**
     * 方式5
     * "  the sky  is blue  "
     * ↓
     * blue is sky the
     * <p>
     * 反转字符数组, 但单词不反转
     * "  the sky  is blue  " -> "  blue is  sky the  "
     * 之后处理空格
     */
    public String reverseWords(String s) {
        final char space = ' ';
        final int len = s.length();
        int index = 0;
        char[] c = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == space) {
                c[index++] = s.charAt(i);
                continue;
            }
            int j = i - 1;
            if (j == -1 || (j >= 0 && s.charAt(j) == space)) {
                int k = i;
                while (k < len && s.charAt(k) != space) {
                    c[index++] = s.charAt(k);
                    k++;
                }
            }
        }
        return cleanSpaces(c, len);
    }

    /**
     * 方式4
     * "  the sky  is blue  "
     * ↓
     * blue is sky the
     * <p>
     * 不使用任何jdk方法, 直接操作字符
     * t_dwh_script_table反转字符数组, 但单词不反转
     * "  the sky  is blue  " -> "  eulb si  yks eht  "
     */
    public String reverseWords(String s) {
        if (s == null) return null;
        final char space = ' ';
        char[] a = s.toCharArray();
        int len = a.length;
        reverse(a, 0, len - 1);
        int i = 0, j = 0;
        while (i < len) {
            while (i < j || i < len && a[i] == space) i++;
            while (j < i || j < len && a[j] != space) j++;
            reverse(a, i, j - 1);
        }
        return cleanSpaces(a, len);
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;
            while (j < n && a[j] != ' ') a[i++] = a[j++];
            while (j < n && a[j] == ' ') j++;
            if (j < n) a[i++] = ' ';
        }
        return String.valueOf(a).substring(0, i);
    }

    /**
     * 方式3
     * "  the sky  is blue  "
     * ↓
     * blue is sky the
     * <p>
     * 不使用jdk方法, 从前往后遍历, 跳过空格, 提取出单词
     */
    public String reverseWords(String s) {
        final char space = ' ';
        StringBuilder sb = new StringBuilder();
        int len = s.length(), i = len - 1;
        while (i >= 0) {
            if (s.charAt(i) == space) {
                i--;
                continue;
            }
            int j = i - 1;
            while (j >= 0 && s.charAt(j) != space) {
                j--;
            }
            if (sb.length() != 0) {
                sb.append(space);
            }
            sb.append(s, j + 1, i + 1);
            i = j - 1;
        }
        return sb.toString();
    }

    /**
     * 方式2
     * "  the sky  is blue  "
     * ↓
     * blue is sky the
     * <p>
     * 不使用jdk方法, 从前往后遍历, 跳过空格, 提取出单词
     * insert方法涉及数组元素移动, 性能可优化
     */
    public String reverseWords(String s) {
        final char space = ' ';
        StringBuilder sb = new StringBuilder();
        int len = s.length(), i = 0;
        int start = 0;
        while (i < len) {
            if (s.charAt(i) == space) {
                i++;
                continue;
            }
            int j = i - 1;
            if (j >= 0 && s.charAt(j) == space) {
                start = i;
                i++;
                continue;
            }
            int k = i + 1;
            if (k == len || (k < len && s.charAt(k) == space)) {
                sb.insert(0, sb.length() == 0 ? "" : space);
                sb.insert(0, s, start, i + 1);
            }
            i++;
        }
        return sb.toString();
    }

    /**
     * 方式1
     * 直接使用split获取所有单词, 倒叙拼接成结果
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

