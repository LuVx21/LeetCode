package org.luvx.question.array;

import org.junit.jupiter.api.Test;

public class SumZeroPairTest {

    @Test
    public void sumZeroPairTest() {
        SumZeroPair exec = new SumZeroPair();
        int[] array = {-1, 1, 1, 2, 3, -2};
        System.out.println(
                exec.sumZeroPair(array)
        );
    }
}