/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */
class Solution {
    /**
     * 两个数组统计各个字符出现的次数
     * count记录两个数组中, 对应字符出现次数相同的字符的个数
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] a1 = new int[26], a2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (a1[i] == a2[i]) {
                count++;
            }
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (count == 26) {
                return true;
            }
            int l = s2.charAt(i) - 'a', r = s2.charAt(i + s1.length()) - 'a';
            if (l == r) {
                continue;
            }
            if (a2[r] == a1[r]) {
                count--;
            }
            a2[r]++;
            if (a2[r] == a1[r]) {
                count++;
            }

            if (a2[l] == a1[l]) {
                count--;
            }
            a2[l]--;
            if (a2[l] == a1[l]) {
                count++;
            }
        }
        return count == 26;
    }

    /**
     * <pre>
     * eidbaooo
     * ab
     *
     * ab,ba
     * ei,id,db,ba,ao,oo,oo
     * </pre>
     * <p>
     * 滑动窗口: 使用数组 TODO: 优化
     */
    public boolean checkInclusion1(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] a1 = new int[26], a2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
            a2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            if (compare(a1, a2)) {
                return true;
            }
            a2[s2.charAt(i - s1.length()) - 'a']--;
            a2[s2.charAt(i) - 'a']++;
        }

        return compare(a1, a2);
    }

    private boolean compare(int[] a1, int[] a2) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 扩展: 给定字符串, 求其组合
     * abc -> abc,acb,bac,bca,cab,cba
     * 组合
     *
     * @param s1
     * @return
     */
    private Set<String> method(String s1) {
        return null;
    }
}

