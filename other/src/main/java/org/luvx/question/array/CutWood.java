package org.luvx.question.array;

public class CutWood {
    /**
     * 给定长度为n的数组，每个元素代表一个木头的长度，木头可以任意截断，从这堆木头中截出至少k个相同长度为m的木块。
     * 已知k，求max(m)。
     * https://leetcode-cn.com/circle/discuss/LV19z5/
     * <p>
     * 4 7 2 10 5 -> 4
     * 二分查找 O(n * log max(len)) len 为木头长度
     */
    public int cutWood(int[] array, int k) {
        int len = array.length, maxLen = array[0];
        for (int i = 1; i < len; i++) {
            maxLen = Math.max(array[i], maxLen);
        }

        int max = 1;
        for (int l = 1; l <= maxLen; ) {
            int middle = l + (maxLen - l) / 2;
            if (cutNum(array, middle) >= k) {
                max = Math.max(max, l);
                l = middle + 1;
            } else {
                maxLen = middle - 1;
            }
        }
        return max;
    }

    private int cutNum(int[] array, int m) {
        int cnt = 0;
        for (int value : array) {
            cnt += value / m;
        }
        return cnt;
    }

    /**
     * 暴力查询
     * O(n * max(len)) len 为木头长度
     */
    public int cutWood0(int[] array, int k) {
        int len = array.length, l = array[0];
        for (int i = 1; i < len; i++) {
            l = Math.max(array[i], l);
        }
        int max = 0;
        for (int m = 1; m <= l; m++) {
            int cnt = 0;
            for (int value : array) {
                cnt += value / m;
            }
            if (cnt >= k) {
                max = Math.max(max, m);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CutWood exec = new CutWood();
        int[] array = {4, 7, 2, 10, 5};
        System.out.println(
                exec.cutWood(array, 5)
        );
    }
}
