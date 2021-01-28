package org.luvx.question;

import java.util.Scanner;

/**
 * @author: Ren, Xie
 */
public class Main {
    public static void main(String[] args) throws Exception {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNextLine()) {
                String s = in.nextLine();
                String[] s1 = s.split(" ");
                int[] nums = new int[s1.length];
                for (int i = 0, size = s1.length; i < size; i++) {
                    nums[i] = Integer.parseInt(s1[i]);
                }
                // ------------------
                int n = steps(nums);
                // int count = numberOfOne(n);
                System.out.println(n);
                // ------------------
            }
        }
    }

    /**
     * 7 5 9 4 2 6 8 3 5 4 3 9 -> 2
     * 1 2 3 7 1 5 9 3 2 1 -> -1
     * 1 2 3 7 5 5 9 3 2 1 -> 2
     *
     * @param nums
     * @return
     */
    private static int steps(int[] nums) {
        int result = -1;
        int len = nums.length, half = len / 2;
        for (int i = 1; i < half; i++) {
            int index = i, count = 1;
            while (true) {
                int num = nums[index];
                index += num;
                if (index <= len - 1) {
                    count++;
                    if (index == len - 1) {
                        break;
                    }
                } else if (index > len - 1) {
                    count = -1;
                    break;
                }
            }
            result = (result == -1) ? count : Math.min(result, count);
        }
        return result;
    }
}
