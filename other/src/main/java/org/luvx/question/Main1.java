package org.luvx.question;

import java.util.Scanner;

/**
 * @author: Ren, Xie
 */
public class Main1 {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                String s = in.nextLine();
                // ------------------
                int n = sum(s);
                System.out.println(n);
                // ------------------
            }
        }
    }

    /**
     * 0123456789
     * 12-034aa -> -31
     *
     * @param s
     * @return
     */
    private static int sum(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int sum = 0;
        for (int i = 0; i < len; ) {
            char c = cs[i];
            if (c == '-') {
                int j = i + 1;
                for (; j < len; j++) {
                    char c1 = cs[j];
                    if (Character.isAlphabetic(c1)) {
                        break;
                    }
                }
                sum -= Integer.parseInt(String.copyValueOf(cs, i + 1, j - i - 1));
                i += j - i + 1;
            } else if (Character.isDigit(c)) {
                sum += Integer.parseInt(c + "");
                i++;
            } else if (Character.isAlphabetic(c)) {
                i++;
            } else if (c == '+') {
                i++;
            }
        }
        return sum;
    }
}
