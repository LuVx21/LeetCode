package org.luvx.coding.foobar.question.array;

import org.luvx.coding.common.more.MorePrints;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://www.nowcoder.com/discuss/353155293708230656">题目: 豆油瓶</a>
 */
public class Q1 {
    /**
     * <pre>
     *   {0, 4, 0}
     *   {4, 0, 6}
     *   {0, 6, 0}
     * </pre>
     * @param arr 行列相同, 且左下和右上以对角线对称
     */
    public static int m1(int[][] arr) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int num = arr[i][j];
                if (num < 3) {
                    continue;
                }
                if (!set.contains(i) && !set.contains(j)) {
                    count++;
                }
                set.add(i);
                set.add(j);
            }
        }
        int left = arr.length - set.size();
        return count + left;
    }

    public static void main(String[] args) {
        // 返回: 2
        int[][] array = new int[][]{
                {0, 4, 0},
                {4, 0, 0},
                {0, 0, 0}
        };
        // 返回: 1
        int[][] array1 = new int[][]{
                {0, 4, 0},
                {4, 0, 6},
                {0, 6, 0}
        };
        MorePrints.println(m1(array), m1(array1));
    }
}
