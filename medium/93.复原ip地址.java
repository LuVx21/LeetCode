/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */
class Solution {
    /**
     * ip地址: 四组, 每组范围为[0, 255](第一组从1开始)
     * 字符串长度为[4,12]
     * 回溯法
     * <p>
     * 25525511135
     * ↓
     * [255,255,11,135],[255,255,111,35]
     */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        if (len < 4 || len > 12) {
            return new ArrayList<>(0);
        }
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                for (int k = 1; k <= 3; k++) {
                    int l = len - i - j - k;
                    if (l < 1 || l > 3) {
                        continue;
                    }
                    String s1 = s.substring(0, i), s2 = s.substring(i, i + j);
                    String s3 = s.substring(i + j, i + j + k), s4 = s.substring(i + j + k);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        list.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return list;
    }

    public boolean isValid(String s) {
        if ((s.charAt(0) == '0' && s.length() > 1) || Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}

