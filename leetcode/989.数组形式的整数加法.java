/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int length = A.length;
        for (int i = length - 1; i >= 0; i--) {
            int a = A[i] + K;
            result.add(Integer.valueOf(a % 10));
            K = a / 10;
            if (i == 0 && K > 0) {
                do {
                    result.add(Integer.valueOf(K % 10));
                    K = K / 10;
                } while (K > 0);
            }
        }

        Collections.reverse(result);
        return result;
    }
}

