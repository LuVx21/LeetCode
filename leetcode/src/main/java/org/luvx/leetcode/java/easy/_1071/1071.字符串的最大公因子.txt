

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        while (true) {
            if (str2.equals(str1)) {
                return str1;
            }
            if (str1.length() < str2.length()) {
                String temp = str1;
                str1 = str2;
                str2 = temp;
            }

            int index = 0;
            for (int i = 0; i < str2.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return "";
                }
                index++;
            }
            str1 = str1.substring(index);
        }
    }
}