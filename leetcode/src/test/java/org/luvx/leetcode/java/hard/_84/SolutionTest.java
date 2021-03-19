package org.luvx.leetcode.java.hard._84;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void largestRectangleArea() {
        final Solution exec = new Solution();
        List<int[]> list = Lists.newArrayList(
                new int[]{1, 2, 4, 5, 3},
                new int[]{1, 2, 4, 5, 3, 2},
                new int[]{1, 2, 4, 5, 3, 4},
                new int[]{1, 2, 4, 5, 3, 6},
                new int[]{6, 2, 1},
                new int[]{1, 2, 6},
                new int[]{3, 1, 6, 4, 5, 2},
                new int[]{5, 6},
                new int[]{2, 1, 5, 6, 2, 3}
        );
        for (int[] array : list) {
            System.out.print(
                    exec.largestRectangleArea(array) + " "
            );
            System.out.println(
                    exec.largestRectangleArea1(array)
            );
        }
    }
}