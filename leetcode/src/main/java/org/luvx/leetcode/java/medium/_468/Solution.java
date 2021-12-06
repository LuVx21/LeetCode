package org.luvx.leetcode.java.medium._468;

// @lc code=start
/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */
class Solution {
    public String validIPAddress(String IP) {
        if (isValidIPv4(IP)) {
            return "IPv4";
        } else if (isValidIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    /**
     * 192.168.0.1
     */
    public boolean isValidIPv4(String ip) {
        int len = ip.length();
        if (len < 7 || ip.charAt(0) == '.' || ip.charAt(len - 1) == '.') {
            return false;
        }
        String[] tokens = ip.split("\\.");
        if (tokens.length != 4) {
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv4Token(token)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidIPv4Token(String token) {
        if (token.startsWith("0") && token.length() > 1) {
            return false;
        }
        try {
            int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt > 255) {
                return false;
            }
            if (parsedInt == 0 && token.charAt(0) != '0') {
                return false;
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /**
     * 2001:0db8:85a3:0000:0000:8a2e:0370:7334
     */
    public boolean isValidIPv6(String ip) {
        int len = ip.length();
        if (len < 15 || ip.charAt(0) == ':' || ip.charAt(len - 1) == ':') {
            return false;
        }
        String[] tokens = ip.split(":");
        if (tokens.length != 8) {
            return false;
        }
        for (String token : tokens) {
            if (!isValidIPv6Token(token)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidIPv6Token(String token) {
        if (token.length() > 4 || token.length() == 0) {
            return false;
        }
        char[] chars = token.toCharArray();
        for (char c : chars) {
            boolean isDigit = c >= 48 && c <= 57;
            boolean isUppercaseAF = c >= 65 && c <= 70;
            boolean isLowerCaseAF = c >= 97 && c <= 102;
            if (!(isDigit || isUppercaseAF || isLowerCaseAF)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

