package org.luvx.question.array;

import org.junit.Test;

import java.util.List;

public class MaxSubTest {
    @Test
    public void maxSubTest() {
        MaxSub exec = new MaxSub();
        List<int[]> list = List.of(
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
            System.out.println(
                    exec.maxSub(array)
            );
        }
    }
}