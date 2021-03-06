/*
 * @lc app=leetcode.cn id=941 lang=java
 *
 * [941] 有效的山脉数组
 */
class Solution {
    public static boolean validMountainArray(int[] A) {
        int length = A.length;
        if (length < 3) {
            return false;
        }

        int maxIndex = 0;
        for (int i = 0; i < length - 1; i++) {
            if (A[i] > A[i + 1]) {
                maxIndex = i;
                break;
            } else if (A[i] == A[i + 1]) {
                return false;
            }
        }
        if (maxIndex == 0 || maxIndex == length - 1) {
            return false;
        }
        for (int i = maxIndex; i < length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean validMountainArray1(int[] A) {
        int length = A.length;
        if (length < 3) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < length - 1; i++) {
            if (i == 0 && A[0] >= A[1]) {
                return false;
            } else if (A[i] == A[i + 1]) {
                return false;
            }

            if (!flag) {
                if (A[i] > A[i + 1]) {
                    flag = true;
                }
                continue;
            } else {
                if (A[i] < A[i + 1]) {
                    return false;
                }
            }
        }

        return flag;
    }
}

