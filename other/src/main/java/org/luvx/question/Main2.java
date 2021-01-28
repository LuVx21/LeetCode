package org.luvx.question;

import java.util.Scanner;

/**
 * @author: Ren, Xie
 */
public class Main2 {
    // public static void main(String[] args) throws Exception {
    //     try (Scanner in = new Scanner(System.in)) {
    //         int i = 0;
    //         while (in.hasNextLine()) {
    //             String s = in.nextLine();
    //             i++;
    //             if (i % 2 == 0) {
    //                 String[] s1 = s.split(" ");
    //                 int[] array = new int[s1.length];
    //                 for (int i1 = 0; i1 < s1.length; i1++) {
    //                     array[i] = Integer.parseInt(s1[i]);
    //                 }
    //                 // ------------------
    //                 int n = max(array);
    //                 System.out.println(n);
    //                 // ------------------
    //             }
    //         }
    //     }
    // }

    /**
     * <pre>
     *     11101
     *      1011
     *     10010
     * </pre>
     * <p>
     * 3 个
     * 重量 3 5 6 -> 11
     * <p>
     * <p>
     * 对应位 操作后 1 越多越好
     *
     * @param weights
     * @return
     */
    private static int max(int[] weights) {
        return 0;
    }

    /**
     * 不进位的2 进制计算
     *
     * @param a
     * @param b
     * @return
     */
    private static void compute(int a, int b) {
        String aa = Integer.toBinaryString(a), bb = Integer.toBinaryString(b);
        int al = aa.length(), bl = bb.length();
        int max = Math.max(al, bl) - 1;
        char[] cs = new char[max + 1];
        int i = al - 1, j = bl - 1;
        for (; i >= 0 && j >= 0; ) {
            char a1 = aa.charAt(i--), b1 = bb.charAt(j--);
            cs[max--] = a1 == b1 ? '0' : '1';
        }

        while (i >= 0) {
            cs[max--] = aa.charAt(i--);
        }
        while (j >= 0) {
            cs[max--] = bb.charAt(j--);
        }

        String s = String.copyValueOf(cs);
        System.out.println(s);
    }

    public static void main(String[] args) {
        int a = 0b11101, b = 0b1011;
        System.out.println(a);
        System.out.println(b);
        compute(a, b);

    }
}
